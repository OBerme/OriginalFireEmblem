package mapa.md;

import entes.md.Ente;

public interface IMapEnte<X, Y> extends IMapa<X, Y>{

	IPosition<Integer, Integer> getEntePosition(Ente ente);

}
