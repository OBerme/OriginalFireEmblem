package presentation.map;

import mapa.md.IPosition;
import mapa.md.Posicion;
import presentation.main.PDefaultValues;

public class AbstractMapSizeFactory {
	
	//Pre: position should be a good position and not null
	//Post: it will return a Position! be carefull, it will return a new position
	//Desc: This method is use to get the relative position, only the X and Y Position that will be Integer positions
	public static IPosition<Integer, Integer> getRelativeIntegerPosition(IPosition<Integer, Integer> position) {
		return new Posicion<Integer, Integer>((position.getX()+1)*PDefaultValues.REC_WIDTH,
				(position.getY()+1)*PDefaultValues.REC_HEIGHT);
		
	}
	
	//Pre: position should be a good position and not null
		//Post: it will return a Position! be carefull, it will return a new position
		//Desc: This method is use to get the relative position move x and y times in the x,y axis 
		//		, only the X and Y Position that will be Integer positions
	public static IPosition<Integer, Integer> getRelativeIntegerPosition(IPosition<Integer, Integer> position,
			int numXPositions, int numYPositions) {
		return new Posicion<Integer, Integer>(
				((position.getX())+numXPositions)*PDefaultValues.REC_WIDTH,
				((position.getY())+numYPositions)*PDefaultValues.REC_HEIGHT+PDefaultValues.HEADER_HEIGHT);
		
	}
}
