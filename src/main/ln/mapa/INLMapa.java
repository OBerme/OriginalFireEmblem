package main.ln.mapa;

import main.md.ente.Ente;
import main.md.mapa.Posicion;


public interface INLMapa<X, Y> {
	void moverEnte(Ente ente, Posicion<X, Y> posi);
	boolean eleminarEnte(Ente ente);
	
}
