package main.ln.mapa;

import main.md.ente.Ente;
import main.md.mapa.Posicion;


public interface INLMapa<X, Y> {
	boolean moverEnte(Ente ente, Posicion<X, Y> posi);
	boolean eleminarEnte(Ente ente);
	String getMapaDesing();
	/**
	 * Pre: posicion tiene que ser una posicion valida del mapa
	 * Post: posi.getEnte() == null
	 */
	void removeEnteFromPosition(Posicion<Integer, Integer> posi);
	
}
