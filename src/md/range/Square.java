package md.range;

import java.util.List;

import mapa.md.IMapa;
import mapa.md.IPosition;

public class Square implements IFigureSquare<Integer,Integer> {
	public int radio;
	private IMapa<Integer, Integer> iMap;
	
	public Square(int radio, IMapa<Integer, Integer> iMap) {
		super();
		this.radio = radio;
		this.iMap = iMap;
	}

	@Override
	public List getPositions(IPosition posi) {
		// TODO Auto-generated method stub
		return RangeSquare.getPositions(posi, iMap, radio);
	}

	@Override
	public IPosition<Integer, Integer> getCenterPosition(IPosition<Integer, Integer> posi) {
		// TODO Auto-generated method stub
		return null;
	}


}
