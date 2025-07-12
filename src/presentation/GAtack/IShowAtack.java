package presentation.GAtack;

import java.util.List;

import mapa.md.IPosition;

public interface IShowAtack {

	void activateAtackPositions(List<IPosition<Integer, Integer>> activatePositions);
	
	void clearActivateAtacks();

	void setCenterPosition(IPosition<Integer, Integer> centerPosition);


}
