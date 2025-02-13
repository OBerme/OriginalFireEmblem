package mapa.ln;

import java.util.List;

import entes.md.Ente;
import mapa.md.IMapa;
import mapa.md.IPosition;
import mapa.md.Posicion;


public interface INLMapa<X, Y> {
	
	String getMapaDesing();
	IPosition<Integer, Integer>[] getPositions();
	int getHeight();
	int getWidth();
	
	List<IPosition<Integer, Integer>> getRangeDiagonal(X x, Y y, X radio);
	
}
