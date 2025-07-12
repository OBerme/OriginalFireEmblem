package presentation.GAtack;

import java.util.List;

import mapa.md.IPosition;

public interface IShowAtackDistance extends IShowAtack {

	void activateDistancePositions(List<IPosition<Integer, Integer>> activateDistancePositions);
	
}
