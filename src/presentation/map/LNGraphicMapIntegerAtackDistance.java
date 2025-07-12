package presentation.map;

import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.IAtack;
import entes.md.IEnte;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.md.IPosition;
import mapa.md.IPositionForEnte;
import presentation.GAtack.IPGraphicAtack;
import presentation.GAtack.IShowAtack;
import presentation.GAtack.IShowAtackDistance;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.ente.IGEnte;
import presentation.graphicOptions.IShowMenus;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.position.IGraphicPosition;
import presentation.map.position.IPositionObserver;

public class LNGraphicMapIntegerAtackDistance extends LNGraphicMapIntegerEnte
	implements ILNGraphicMapIntegerAtackDistance, IShowAtackDistance {
	public IGraphicMapAtackDistance iMap;
	
	//Cache positions
	private boolean atackActivate;
	
	private List<IPosition<Integer, Integer>> dAPositions; //Distance Active Positions
	private List<IPosition<Integer, Integer>> aAPositions; //Atack Active Positions
	
	
	//Mouse subjects
	private IMouseHoverSubject mHSubject;
	
	public LNGraphicMapIntegerAtackDistance(IGraphicMapAtackDistance gMap, 
			ILNMapaMatrixEntes lnMap, IShowMenus menuContro, IGraphicMapAtackDistance iMap) {
		super(gMap, lnMap, menuContro);
		this.iMap = iMap;
		
		// TODO Auto-generated constructor stub
	}

	//Pre: The positions should contain some IGEnte inside
	//Post: if the attack was showed it will return a list of the gEntes reached,
	//			besides it will return an empty List
	@Override 
	public List<IEnte> getEntesAtacked(){
		if(atackActivate) {
			List<IEnte> gEntes = new ArrayList<IEnte>();
			for(IPosition<Integer, Integer> nPosi : aAPositions ) {
				IPGraphicPosition<Integer, Integer> nGPPosi = iMap.getGraphicPosition(nPosi.getX(), nPosi.getY());
				
				IPosition<Integer, Integer> nGPosi =  nGPPosi.getgPosition();
				if(nGPosi instanceof IPositionForEnte) {
					IPositionForEnte nPosiEnte = (IPositionForEnte) nGPosi;
					if(nPosiEnte.hasEnte()) {
						IEnte ente =  nPosiEnte.getEnte();
						gEntes.add(ente);
					}
				}
			}
			return gEntes;
		}
		return new ArrayList<IEnte>(); //TODO
	}

	
	//TODO put these method in other interface different
	@Override
	public void activateCells(List<IPosition<Integer, Integer>> list) {
		iMap.activateCells(list);
	}
	

	@Override
	public void activateAtackPositions(List<IPosition<Integer, Integer>> activatePositions) {
		this.atackActivate = true;
		this.aAPositions = activatePositions;
		this.iMap.activateAtackPositions(activatePositions);
	}

	@Override
	public IPGraphicPosition<Integer, Integer> getGraphicPosition(IPosition<Integer, Integer> lastEP) {
		// TODO Auto-generated method stub
		return iMap.getGraphicPosition(lastEP.getX(), lastEP.getY());
	}

	@Override
	public void changePositions(IPGraphicPosition<Integer, Integer> fPGP, IPGraphicPosition<Integer, Integer> sPGP) {
		iMap.changePositions(fPGP, sPGP);	
	}

	

	@Override
	public void activateDistancePositions(List<IPosition<Integer, Integer>> activateDistancePositions, IPosition<Integer,Integer> sPosition) {
		this.dAPositions = activateDistancePositions;
		this.iMap.activateDistancePositions(activateDistancePositions,sPosition);
	}

	@Override
	public void clearActivateAtacks() {
		this.iMap.clearActivateAtackPositions(aAPositions);
		aAPositions.clear();
	}

	@Override
	public void activateDistancePositions(List<IPosition<Integer, Integer>> activateDistancePositions) {
		
	}

	@Override
	public boolean activeDistancePosition(IPosition<Integer, Integer> sPosi) {
		// TODO Auto-generated method stub
		return iMap.activeDistancePosition(sPosi);
	}

	@Override
	public void setCenterPosition(IPosition<Integer, Integer> centerPosition) {
		if(iMap.hasPosition(centerPosition.getX(), centerPosition.getY())) {
			iMap.activateCenterPosition(centerPosition);
		}
		
	}

	
	
	
}
