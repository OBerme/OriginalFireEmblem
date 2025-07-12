package md.range;

import java.util.List;

import mapa.md.IMapa;
import mapa.md.IPosition;

public class Triangle implements IFigureTriangle<Integer, Integer>{
	private int radio;
	private IMapa<Integer, Integer> iMap;
	private FigureTriangleEnum direction;
	
	public Triangle(int radio, IMapa<Integer, Integer> iMap, FigureTriangleEnum direction) {
		super();
		this.radio = radio;
		this.iMap = iMap;
		this.direction = direction;
	}

	@Override
	public List<IPosition<Integer, Integer>> getPositions(IPosition<Integer, Integer> posi) {
		// TODO Auto-generated method stub
		return RangeTriangle.getPositions(posi, iMap, radio, direction);
	}

	@Override
	public IPosition<Integer, Integer> getCenterPosition(IPosition<Integer, Integer> posi) {
		return RangeDiagonal.getCenterPosition(posi);
	}
}
