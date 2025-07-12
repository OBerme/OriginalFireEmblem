package presentation.map;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.List;

import entes.IEnteEvents;
import entes.md.IEnte;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.INLMapa;
import mapa.md.IPosition;
import mapa.md.IPositionForEnte;
import mapa.md.IPositionable;
import presentation.GAtack.IShowAtack;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.ente.IGEnte;
import presentation.main.PDefaultValues;
import presentation.map.jbutton.IAbstractFactoryJButtonActions;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.IPGraphicPositionInteger;
import presentation.map.jbutton.IPGraphicPositionIntegerAtack;
import presentation.map.jbutton.IPGraphicPositionIntegerAtackDistance;
import presentation.map.jbutton.PGraphicPositionIntegerAtack;

public class GraphicMapIntegerEnteAtack extends GraphicMapIntegerEnte  
	implements IGraphicMapAtack, IEnteEvents {
	
	

	public GraphicMapIntegerEnteAtack(ILNMapaMatrixEntes map, IPGraphicPositionInteger[][] gPositions, int x, int y,
			IAbstractFactoryJButtonActions aFJButtons) throws Exception {
		super(map, gPositions, x, y, aFJButtons);
		
		if(!(gPositions[0][0] instanceof IPGraphicPositionIntegerAtack)) throw new Exception("The gPositions of the GraphicMap aren't IPGraphicPositionIntegerAtack");
		
		
	}



	@Override
	public void activateAtackPositions(List<IPosition<Integer, Integer>> posis) {
		for(IPosition<Integer, Integer> nPosi : posis) {
			((PGraphicPositionIntegerAtack)getGraphicPosition(nPosi.getX(), nPosi.getY())).activateAtack(); 	
		}
	}
	

	
	@Override
	public IPGraphicPosition<Integer, Integer> getPositionEnte(IEnte iEnte) {
		
		for(int x = 0; x < gPositions.length; x++) {
			for(int y = 0; y < gPositions[x].length; y++) {
				IPositionForEnte nPFE = (IPositionForEnte)getGraphicPosition(x, y);
				if(nPFE.hasEnte() && nPFE.getEnte().equals(iEnte)) {
					return getGraphicPosition(x, y);
				}
			}
		}
		
		return null;
	}

	@Override
	public void onEnteDies(IEnte ente) {
		IPGraphicPosition<Integer, Integer> nPosi =  getPositionEnte(ente);
		nPosi.refreshButton();
		
	}

	@Override
	public void onEnteReciveAtack(IEnte ente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnteChangeHp(IEnte ente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearActivateAtackPositions(List<IPosition<Integer, Integer>> aAPositions) {
		for(IPosition<Integer, Integer> nPosi : aAPositions) {
			((IPGraphicPositionIntegerAtack)gPositions[nPosi.getX()][nPosi.getY()]).deactivateAtack();
		}
		
	}

	

}
