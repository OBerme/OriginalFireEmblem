package entes;

import entes.md.Ente;
import mapa.md.Posicion;

public interface IEnteEvents {
	void onEnteDies(Ente ente);

	void onEnteReciveAtack(Ente ente);
}
