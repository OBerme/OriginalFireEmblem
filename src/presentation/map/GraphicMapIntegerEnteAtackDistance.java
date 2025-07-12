package presentation.map;

import java.util.List;

import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.INLMapa;
import mapa.md.IPosition;
import mapa.md.IPositionable;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.ente.IGEnte;
import presentation.map.jbutton.IAbstractFactoryJButtonActions;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.IPGraphicPositionInteger;
import presentation.map.jbutton.IPGraphicPositionIntegerAtack;
import presentation.map.jbutton.IPGraphicPositionIntegerAtackDistance;
import presentation.map.jbutton.PGraphicOPositionIntegerAtackDistance;
import presentation.map.jbutton.PGraphicPositionIntegerAtack;

public class GraphicMapIntegerEnteAtackDistance
	extends GraphicMapIntegerEnteAtack implements IGraphicMapAtackDistance{

	public GraphicMapIntegerEnteAtackDistance(ILNMapaMatrixEntes map, IPGraphicPositionInteger[][] gPositions, int x,
			int y, IAbstractFactoryJButtonActions aFJButtons) throws Exception {
		super(map, gPositions, x, y, aFJButtons);
		if(!(gPositions[0][0] instanceof IPGraphicPositionIntegerAtackDistance)) throw new Exception("The gPositions of the GraphicMap aren't IPGraphicPositionIntegerAtackDistance");
	}

	@Override
	public void activateDistancePositions(List<IPosition<Integer, Integer>> posis,IPosition<Integer, Integer> atackerPosi) {
		for(IPosition<Integer, Integer> nPosi : posis) {
			((PGraphicOPositionIntegerAtackDistance)getGraphicPosition(nPosi.getX(), nPosi.getY())).activateDistance(atackerPosi);; 	
		}
		
	}

	@Override
	public boolean activeDistancePosition(IPosition<Integer, Integer> sPosi) {
		// TODO Auto-generated method stub
		int x = sPosi.getX();
		int y = sPosi.getY();
		if(!hasPosition(x, y)) return false;
		return ((IPGraphicPositionIntegerAtackDistance)getGraphicPosition(x, y)).isActiveDistance();
	}

	@Override
	public void activateCenterPosition(IPosition<Integer, Integer> centerPosition) {
		((IPGraphicPositionIntegerAtack)getGraphicPosition(centerPosition.getX(), centerPosition.getY()))
					.setCenterPositionAtack();
	}


}
