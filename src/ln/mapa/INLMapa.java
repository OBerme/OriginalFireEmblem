package ML.mapa;

import MD.Mapa.Posicion;
import md.ente.Ente;

public interface INLMapa<X, Y> {
	void moverEnte(Ente ente, Posicion<X, Y> posi);
	boolean eleminarEnte(Ente ente);
	
}
