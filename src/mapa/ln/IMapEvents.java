package mapa.ln;

import mapa.md.Posicion;

public interface IMapEvents<T, U> {
	void onPositionChange(Posicion<T, U> posicion);
}
