package md.range;

import java.util.ArrayList;
import java.util.List;

import mapa.ln.AbstractFactoryPositionInteger;
import mapa.md.IMapa;
import mapa.md.IPosition;
import mapa.md.Mapa;
import mapa.md.Posicion;

public class RangeToPoint {
	//Pre: sPoint is the starter point, fPoint is the final point and should be different
	//Post: it will generate a positions from the starter point to the final point 
	//			INCLUDED the sPosi and the fPosi
	public  static final List<IPosition<Integer, Integer>> getPositions(
			IPosition<Integer, Integer> sPoint,  IPosition<Integer, Integer> fPoint,
			IMapa<Integer, Integer> map) {
		
		
		List<IPosition<Integer, Integer>> positions = new ArrayList<IPosition<Integer,Integer>>();
		
		int dX = sPoint.getX() - fPoint.getX();
		
		if(dX == 0) {
			int dY = sPoint.getY() - fPoint.getY();
			int x = sPoint.getX();
			if(dY < 0) {
				
				for(int y = sPoint.getY(); y < fPoint.getY(); y++) {
					positions.add(map.getPosition(x , y));
				}
			}
			else { //problems with the equals
				for(int y = sPoint.getY(); y > fPoint.getY(); y--) {
					positions.add(map.getPosition(x , y));
				}
			}
		}
		else {
			int y = sPoint.getY();
			if(dX < 0) {
				for(int x = sPoint.getX(); x < fPoint.getX(); x++) {
					positions.add(map.getPosition(x, y));
				}
			}
			else {
				for(int x = sPoint.getX(); x > fPoint.getX(); x--) {
					positions.add(map.getPosition(x, y));
				}
			}
		}
		positions.add(fPoint);
		
		return positions; 
	}
}
