package ml.mapa;

<<<<<<<< HEAD:src/ln/mapa/INLMapa.java
import MD.Mapa.Posicion;
import md.ente.Ente;
========
import md.ente.Ente;
import md.mapa.Posicion;
>>>>>>>> IEnteEvent:src/ml/mapa/INLMapa.java

public interface INLMapa<X, Y> {
	void moverEnte(Ente ente, Posicion<X, Y> posi);
	boolean eleminarEnte(Ente ente);
	
}
