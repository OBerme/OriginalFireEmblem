package mapa.ln;

import mapa.md.IPosition;
import mapa.md.Posicion;

public interface IMapEvents<T, U> {
	void onPositionChange(IPosition<Integer, Integer> posi);
}
