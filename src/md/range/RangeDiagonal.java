package md.range;

import java.util.ArrayList;
import java.util.List;

import mapa.md.IPosition;
import mapa.md.Mapa;
import mapa.md.Posicion;

public class RangeDiagonal {
	//Pre: the radio should be more than 0 and the map and posi should be them not null 
	//Post: it will generate a positions with a form of a "diagonal" using the radio that represents the DiagonalRange
	public  static final List<IPosition<Integer, Integer>> getPositions(Posicion<Integer, Integer> posi, Mapa<Integer, Integer> map, Integer radio) {
		List<IPosition<Integer, Integer>> positions = new ArrayList<IPosition<Integer,Integer>>();
		
		Posicion<Integer, Integer> initPosition = new Posicion<Integer, Integer>(posi.getX(), posi.getY() - radio);
		int acumu = 1;
		int i = 0;
		for(int y = initPosition.getY(); y < posi.getY(); y++) {
			int rInitPosit = initPosition.getX()-i;
			for(int x = rInitPosit; x < rInitPosit+acumu; x++) { //the acumulator for the next bloqs of the diagonal
				Posicion<Integer, Integer> nPosi =  new Posicion<Integer, Integer>(x, y);
				if(map.hasPosition(nPosi)) {
					positions.add(nPosi);
				}
			}
			i++;
			acumu+=2;
		}
		
		
		//Inverse formula
		for(int y = posi.getY(); y <= (posi.getY()+radio); y++) {
			int rInitPosit = initPosition.getX()-i;
			for(int x = rInitPosit; x < rInitPosit+acumu; x++) { //the acumulator for the next bloqs of the diagonal
				Posicion<Integer, Integer> nPosi =  new Posicion<Integer, Integer>(x, y);
				if(map.hasPosition(nPosi)) {
					positions.add(nPosi);
				}
			}
			i--;
			acumu-=2;
		}
		return positions; 
	}
}
