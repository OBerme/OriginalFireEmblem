package md.range;

import java.util.ArrayList;
import java.util.List;

import mapa.md.IPosition;
import mapa.md.Mapa;
import mapa.md.Posicion;

public final class RangeSquare {

	public  static final List<IPosition<Integer, Integer>> getPositions(Posicion<Integer, Integer> posi, Mapa<Integer, Integer> map, Integer radio) {
//		Posicion<Integer, Integer>[] positions = new Posicion[(int)Math.pow(radio, 2)];
				List<IPosition<Integer, Integer>> positions = new ArrayList<IPosition<Integer,Integer>>();
		
		Posicion<Integer, Integer> initPosition = new Posicion<Integer, Integer>(posi.getX()-radio, posi.getY() - radio);
		for(int y = initPosition.getY(); y <= posi.getY() + radio; y++) {
			
			for(int x = initPosition.getX(); x <= posi.getX()+radio; x++) { //the acumulator for the next bloqs of the diagonal
				Posicion<Integer, Integer> nPosi =  new Posicion<Integer, Integer>(x, y);
				if(map.hasPosition(nPosi)) {
					positions.add(nPosi);
				}
			}
			
		}
		
		
		return positions; 
	}
}
