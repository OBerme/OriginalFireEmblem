package ML.mapa;

import MD.Ente.Ente;
import MD.Mapa.Posicion;

public interface INLMapa<X, Y> {
	void moverEnte(Ente ente, Posicion<X, Y> posi);
	boolean eleminarEnte(Ente ente);
	
}
