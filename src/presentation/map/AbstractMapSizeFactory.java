package presentation.map;

import mapa.md.IPosition;
import mapa.md.Posicion;
import mapa.md.RelativePosicion;
import presentation.main.PDefaultValues;

public class AbstractMapSizeFactory {
	
	//Pre: position should be a good position and not null
	//Post: it will return a Position! be carefull, it will return a new position
	//Desc: This method is use to get the relative position, only the X and Y Position that will be Integer positions
	public static IRelativePosition getRelativeIntegerPosition(IPosition<Integer, Integer> position) {
		return new RelativePosicion((position.getX()+1)*PDefaultValues.REC_WIDTH,
				(position.getY()+1)*PDefaultValues.REC_HEIGHT);
		
	}
	
	//Pre: position should be a good position and not null
		//Post: it will return a Position! be carefull, it will return a new position
		//Desc: This method is use to get the relative position move x and y times in the x,y axis 
		//		, only the X and Y Position that will be Integer positions
	public static IRelativePosition getRelativeIntegerPosition(IPosition<Integer, Integer> position,
			int numXPositions, int numYPositions) {
		return new RelativePosicion(
				((position.getX())+numXPositions)*PDefaultValues.REC_WIDTH,
				((position.getY())+numYPositions)*PDefaultValues.REC_HEIGHT+PDefaultValues.HEADER_HEIGHT);
		
	}
	
	
	public static IPosition<Integer, Integer> getInverseRelativeIntegerPosition(IRelativePosition position,
			int numXPositions, int numYPositions) {
		return new Posicion<Integer, Integer>(
				(position.getX())/PDefaultValues.REC_WIDTH +numXPositions,
				(position.getY()-PDefaultValues.HEADER_HEIGHT)/PDefaultValues.REC_HEIGHT+numYPositions);
		
	}
}
