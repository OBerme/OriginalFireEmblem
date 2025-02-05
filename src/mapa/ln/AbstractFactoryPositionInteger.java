package mapa.ln;

import mapa.md.IPosition;
import mapa.md.MapaMatrix;
import mapa.md.MapaMatrixEnteGroup;
import mapa.md.MapaMatrixEnteGroupActionable;
import mapa.md.Posicion;
import mapa.md.PosicionGroupable;
import mapa.md.PosicionGroupableActionable;
import presentation.map.GraphicMap;
import presentation.map.GraphicPositionInteger;

public class AbstractFactoryPositionInteger {
	//Pre: The map should have some positions
	//Post: if the map hasen't the any kind of Position will return a null
	public static IPosition<Integer,Integer> getPosition(Integer x, Integer y, MapaMatrix map){
		if(map instanceof MapaMatrixEnteGroupActionable) 
			return new PosicionGroupableActionable<Integer, Integer>(x, y);
		else if(map instanceof MapaMatrixEnteGroup)
			return new PosicionGroupable<Integer, Integer>(x, y);
		else if(map instanceof MapaMatrix)
			return new Posicion<Integer, Integer>(x, y);
		
		return null;
		
			
	}
}
