package presentation.map;

import java.util.List;

import entes.md.IEnte;
import mapa.md.IPosition;
import presentation.ente.IGEnte;
import presentation.map.jbutton.IPGraphicPosition;

public interface ILNGraphicMapIntegerAtackDistance extends ILNGraphicMapIntegerEnte {

	void activateCells(List<IPosition<Integer, Integer>> list);

	IPGraphicPosition<Integer, Integer> getGraphicPosition(IPosition<Integer, Integer> lastEP);

	void changePositions(IPGraphicPosition<Integer, Integer> fPGP, IPGraphicPosition<Integer, Integer> sPGP);

	void activateAtackPositions(List<IPosition<Integer, Integer>> activatePositions);
	
	List<IEnte> getEntesAtacked();
	
	void activateDistancePositions(List<IPosition<Integer, Integer>> activateDistancePositions,
				IPosition<Integer,Integer> sPosition);

	boolean activeDistancePosition(IPosition<Integer, Integer> sPosi);
	
	

}
