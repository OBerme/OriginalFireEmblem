package presentation.map;

import java.util.List;

import mapa.md.IPosition;
import presentation.map.jbutton.IPGraphicPosition;

public interface IGraphicMap {

	//Pre: Positions should be not null and empty
	//Post: It will activate/show the positions in the graphicMap
	void activateCells(List<IPosition<Integer, Integer>> positions);

	//Pre: the positions should be not null and it needs to be in the map
	//Post: it will return the GraphicPosition of that position
	IPGraphicPosition<Integer, Integer> getGraphicPosition(IPosition<Integer, Integer> position);

	void changePositions(IPGraphicPosition<Integer, Integer> fGPosition,
			IPGraphicPosition<Integer, Integer> sGPosition);

	
	public abstract void refreshMap();
}
