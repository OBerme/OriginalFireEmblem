package md.range;

import java.util.ArrayList;
import java.util.List;

import mapa.md.Mapa;
import mapa.md.Posicion;

public final class RangeRectangle {	
	//Pre: the width and height should be width != height and both > 0, the posi and map should be not null
	//Post: it will return a positions with the max position as x = witdh + posi.X and y = height + posi.Y 
	public  static final List<Posicion<Integer, Integer>> getPositions(Posicion<Integer, Integer> posi, Mapa<Integer, Integer> map, int width, int height) {
//		Posicion<Integer, Integer>[] positions = new Posicion[(int)Math.pow(radio, 2)];
				List<Posicion<Integer, Integer>> positions = new ArrayList<Posicion<Integer,Integer>>();
		
		int fheight = posi.getY()+height;
		int fwidth = posi.getX()+width;
		for(int y = posi.getY() - height; y <= fheight; y++) {
			
			for(int x = posi.getX()-width; x <= fwidth; x++) { //the acumulator for the next bloqs of the diagonal
				Posicion<Integer, Integer> nPosi =  new Posicion<Integer, Integer>(x, y);
				if(map.hasPosition(nPosi)) {
					positions.add(nPosi);
				}
			}
			
		}
		
		
		return positions; 
	}
}
