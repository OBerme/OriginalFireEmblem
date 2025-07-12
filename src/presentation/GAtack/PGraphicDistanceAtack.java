package presentation.GAtack;

import presentation.MouseHoverObserver.IMouseHoverObserver;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.MouseHoverObserver.PCalculatorRange;
import presentation.map.IGraphicMapAtack;
import presentation.map.IGraphicMapAtackDistance;
import presentation.map.ILNGraphicMapIntegerAtackDistance;

import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import acciones.md.ataque.Ataque;
import mapa.md.IPosition;
import md.range.IFigure;
import md.range.RangeToPoint;

@objid ("c7643aad-85de-48b2-a004-cd145c79d829")
public class PGraphicDistanceAtack extends PGraphicAtack
	implements IMouseHoverObserver, IPGraphicDistanceAtack {
	@objid ("fe9aec8b-85c9-4f7f-a208-06474ae71b13")
	
	
    private int maxDistance;
	private IMouseHoverSubject hoverSubject;
	private IShowAtackCached iSACached;
		
	
	public PGraphicDistanceAtack(Ataque atack, IGraphicMapAtack map, IFigure<Integer, Integer> figure,
			IShowAtackDistance distanceShowable, int maxDistance, IMouseHoverSubject hoverSubject,IShowAtackCached iSACached) {
		super(atack, map, figure, distanceShowable);
		this.maxDistance = maxDistance;
		this.hoverSubject = hoverSubject;
		this.iSACached = iSACached;
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouseRange() {
		atackShowable.clearActivateAtacks();
		atackShowable.activateAtackPositions(getActivatePositions(hoverSubject.getRangerPosition()));
		
	}

	@Override
	public List<IPosition<Integer, Integer>> getActivatePositions(IPosition<Integer, Integer> posi) {
		IPosition<Integer, Integer> atackPosi = map.getPosition(posi.getX()+getRelativeMaxDistance(), posi.getY());
		atackShowable.setCenterPosition(figure.getCenterPosition(atackPosi));
		return figure.getPositions(atackPosi);
	}
	
	public List<IPosition<Integer, Integer>> getChangedActivatePositions(IPosition<Integer, Integer> posi, int maxRange) {
		// TODO Auto-generated method stub
		
		return figure.getPositions(map.getPosition(posi.getX()+maxRange, posi.getY()));
	}
	
	@Override
	public List<IPosition<Integer, Integer>> getActivateDistancePositions(IPosition<Integer, Integer> posi) {
		// TODO Auto-generated method stub
		return RangeToPoint.getPositions(map.getPosition(posi.getX()+1, posi.getY()),
				map.getPosition(posi.getX()+maxDistance, posi.getY()), map);
	}

	
	
	public List<IPosition<Integer, Integer>> getChangedActivateDistancePositions(IPosition<Integer, Integer> posi, int maxRange) {
		// TODO Auto-generated method stub
		return RangeToPoint.getPositions(map.getPosition(posi.getX()+1, posi.getY()),
				map.getPosition(posi.getX()+maxRange, posi.getY()), map);
	}
	
	@Override
	public int getMaxDistance() {
		return maxDistance;
	}
	
	

	@Override
	public void activatePositions(IPosition<Integer, Integer> lastPosition) {
		iSACached.setCacheAtack(this);
		activateAtackPositions(lastPosition);
		
	}
	
	private void activateAtackPositions(IPosition<Integer, Integer> lastPosition) {
		
		
		atackShowable.activateAtackPositions(getActivatePositions(lastPosition));
		((IShowAtackDistance)atackShowable).activateDistancePositions(getActivateDistancePositions(lastPosition));
	}

	private int getRelativeMaxDistance() {
		return maxDistance+1;
	}

	@Override
	public void onChangeActivatePosition(IPosition<Integer, Integer> atackerPosi, int maxRange) {
		if(maxRange != getRelativeMaxDistance()) {
			List<IPosition<Integer, Integer>>  positiAtack = getChangedActivatePositions(atackerPosi, maxRange);
			if(positiAtack.contains(atackerPosi)) { //for the last position of the atacks
				positiAtack.remove(atackerPosi);
			}
			
			atackShowable.activateAtackPositions(positiAtack);		
			((IShowAtackDistance)atackShowable).activateDistancePositions(getChangedActivateDistancePositions(atackerPosi, maxRange));	
		}
		else 
			activateAtackPositions(atackerPosi);
	}



	@Override
	public void onChangeActivatePosition(IPosition<Integer, Integer> posi) {
		activateAtackPositions(posi);		
	}



}
