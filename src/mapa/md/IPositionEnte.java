package mapa.md;

import entes.md.Ente;

public interface IPositionEnte<X, Y>  extends IPosition<X, Y>{
	boolean hasEnte();
	Ente getEnte();
}
