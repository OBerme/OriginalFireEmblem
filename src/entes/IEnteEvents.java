package entes;

import entes.md.Ente;
import entes.md.IEnte;
import mapa.md.Posicion;

public interface IEnteEvents {
	void onEnteDies(IEnte ente);

	void onEnteReciveAtack(IEnte ente);
	void onEnteChangeHp(IEnte ente);
	
}
