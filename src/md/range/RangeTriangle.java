package md.range;

import java.util.ArrayList;
import java.util.List;

import mapa.md.IMapa;
import mapa.md.IPosition;
import mapa.md.Posicion;

public class RangeTriangle {

	public  static final List<IPosition<Integer, Integer>> getPositions(IPosition<Integer, Integer> posi,
					IMapa<Integer, Integer> map, Integer radio, FigureTriangleEnum direction) {
		List<IPosition<Integer, Integer>> positions = new ArrayList<IPosition<Integer,Integer>>();
		
		IPosition<Integer, Integer> initPosition = new Posicion<Integer, Integer>(posi.getX(), posi.getY() - radio);
		int acumu = 1;
		int i = 0;
		
		
		for(int y = initPosition.getY(); y < posi.getY(); y++) {
			int rInitPosit = initPosition.getX()-i;
			for(int x = rInitPosit; x < rInitPosit+acumu; x++) { //the acumulator for the next bloqs of the diagonal
				
				if(map.hasPosition(x, y) && isInRange(x, y, initPosition, initPosition, direction) ) { 
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
				if(map.hasPosition(x, y) && isInRange(x, y, initPosition, initPosition, direction)) { 
					positions.add(map.getPosition(x, y));
				}
			}
			i--;
			acumu-=2;
		}
		return positions; 
	}
	
	private static boolean isInRange(int x, int y,
			IPosition<Integer, Integer> initPosition,  IPosition<Integer, Integer> nPosition, FigureTriangleEnum direction) {
		if(direction.equals(FigureTriangleEnum.RIGHT)) {
			return initPosition.getY() <= nPosition.getY(); 
		}
		return false;
	}
}
