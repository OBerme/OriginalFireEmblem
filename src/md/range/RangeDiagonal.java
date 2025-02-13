package md.range;

import java.util.ArrayList;
import java.util.List;

import mapa.ln.AbstractFactoryPositionInteger;
import mapa.md.IMapa;
import mapa.md.IPosition;
import mapa.md.Mapa;
import mapa.md.Posicion;

public class RangeDiagonal {
	//Pre: the radio should be more than 0 and the map and posi should be them not null 
	//Post: it will generate a positions with a form of a "diagonal" using the radio that represents the DiagonalRange
	public  static final List<IPosition<Integer, Integer>> getPositions(IPosition<Integer, Integer> posi, IMapa<Integer, Integer> map, Integer radio) {
		List<IPosition<Integer, Integer>> positions = new ArrayList<IPosition<Integer,Integer>>();
		
		IPosition<Integer, Integer> initPosition = new Posicion<Integer, Integer>(posi.getX(), posi.getY() - radio);
		int acumu = 1;
		int i = 0;
		for(int y = initPosition.getY(); y < posi.getY(); y++) {
			int rInitPosit = initPosition.getX()-i;
			for(int x = rInitPosit; x < rInitPosit+acumu; x++) { //the acumulator for the next bloqs of the diagonal
				
				if(map.hasPosition(x, y)) { 
					positions.add( map.getPosition(x, y));
				}
			}
			i++;
			acumu+=2;
		}
		
		
		//Inverse formula
		for(int y = posi.getY(); y <= (posi.getY()+radio); y++) {
			int rInitPosit = initPosition.getX()-i;
			for(int x = rInitPosit; x < rInitPosit+acumu; x++) { //the acumulator for the next bloqs of the diagonal
				if(map.hasPosition(x, y)) { 
					positions.add(map.getPosition(x, y));
				}
			}
			i--;
			acumu-=2;
		}
		return positions; 
	}
}
