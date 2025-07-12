package md.range;

import java.util.List;

import mapa.md.IPosition;

public interface IFigure<X, Y> {
	List<IPosition<X, Y>> getPositions(IPosition<X, Y> posi);
	
	IPosition<X, Y> getCenterPosition(IPosition<Integer, Integer> posi);
}
