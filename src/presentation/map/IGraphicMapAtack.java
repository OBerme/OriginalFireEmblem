package presentation.map;

import java.util.List;

import entes.md.IEnte;
import mapa.md.IPosition;
import presentation.ente.IGEnte;
import presentation.map.jbutton.IPGraphicPosition;

public interface IGraphicMapAtack extends IGraphicMapIntegerEnte {
	void activateAtackPositions(List<IPosition<Integer, Integer>> posis);
	
	IGEnte getEntePosition(IPosition<Integer, Integer> posicion);

	IPGraphicPosition<Integer, Integer> getPositionEnte(IEnte iEnte);
	
	void clearActivateAtackPositions(List<IPosition<Integer, Integer>> aAPositions);
}
