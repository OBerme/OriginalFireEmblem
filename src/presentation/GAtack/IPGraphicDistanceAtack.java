package presentation.GAtack;

import java.util.List;

import mapa.md.IPosition;
import presentation.map.IGraphicMapAtackDistance;

public interface IPGraphicDistanceAtack extends IPGraphicAtack{
	int getMaxDistance();

	List<IPosition<Integer, Integer>> getActivateDistancePositions(IPosition<Integer, Integer> posi);

	void onChangeActivatePosition(IPosition<Integer, Integer> atackerPosi, int maxRange);

	void onChangeActivatePosition(IPosition<Integer, Integer> atackerPosi);

	
}
