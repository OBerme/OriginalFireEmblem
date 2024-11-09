package ml.mapa;

import md.ente.Ente;
import md.mapa.Posicion;

public interface INLMapa<X, Y> {
	void moverEnte(Ente ente, Posicion<X, Y> posi);
	boolean eleminarEnte(Ente ente);
	
}
