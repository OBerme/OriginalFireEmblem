package mapa.ln;

import mapa.md.IPosition;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;
import mapa.md.PosicionGroupable;
import mapa.md.PosicionGroupableActionable;
import presentation.map.GraphicMap;
import presentation.map.GraphicPosition;

public class AbstractFactoryPositionInteger {
	//Pre: The map should have some positions
	//Post: if the map hasen't the any kind of Position will return a null
	public static IPosition<Integer,Integer> getPosition(Integer x, Integer y, MapaMatrix map){
		IPosition<Integer, Integer> aPosi = map.getPosicion(0,0);
		if(aPosi instanceof PosicionGroupableActionable<Integer, Integer>) 
			return new PosicionGroupableActionable<Integer, Integer>(x, y);
		else if(aPosi instanceof PosicionGroupable<Integer, Integer>)
			return new PosicionGroupable<Integer, Integer>(x, y);
		else if(aPosi instanceof Posicion<Integer, Integer>)
			return new Posicion<Integer, Integer>(x, y);
		
		return null;
		
			
	}
}
