package mapa.ln;

import java.util.List;

import entes.md.Ente;
import mapa.md.Posicion;


public interface INLMapa<X, Y> {
	
	String getMapaDesing();
	Posicion<Integer, Integer>[] getPositions();
	
	
}
