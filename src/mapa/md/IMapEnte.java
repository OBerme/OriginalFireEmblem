package mapa.md;

import entes.md.Ente;
import entes.md.IEnte;

public interface IMapEnte<X, Y> extends IMapa<X, Y>{

	IPosition<Integer, Integer> getEntePosition(IEnte ente);

}
