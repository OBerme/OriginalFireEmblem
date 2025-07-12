package md.range;

import java.util.List;

import mapa.md.IMapa;
import mapa.md.IPosition;
import presentation.map.IGraphicMap;

public class Rombo implements IFigureRombo<Integer, Integer>{
	private int radio;
	private IMapa<Integer, Integer> iMap;
	
	
	public Rombo(int radio, IMapa<Integer, Integer> iMap) {
		super();
		this.radio = radio;
		this.iMap = iMap;
	}

	@Override
	public List<IPosition<Integer, Integer>> getPositions(IPosition<Integer, Integer> posi) {
		// TODO Auto-generated method stub
		return RangeDiagonal.getPositions(posi, iMap, radio);
	}

	@Override
	public IPosition<Integer, Integer> getCenterPosition(IPosition<Integer, Integer> posi) {
		return RangeDiagonal.getCenterPosition(posi);
	}

	
	
}
