package presentation.map;

import java.util.List;

import mapa.md.IPosition;
import presentation.ente.IGEnte;

public interface IGraphicMapAtackDistance extends IGraphicMapAtack {

	void activateDistancePositions(List<IPosition<Integer, Integer>> activateDistancePositions
			,IPosition<Integer, Integer> atackerPosi);

	boolean activeDistancePosition(IPosition<Integer, Integer> sPosi);

	void activateCenterPosition(IPosition<Integer, Integer> centerPosition);

	

	
}
