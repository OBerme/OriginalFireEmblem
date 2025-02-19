package entes;

import java.util.List;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;

public interface Atacable {
	//Pre: ----
	//Post: se devolvera una lista con ataques variables, nunca sera nula pero si puede estar vacia
	public List<IAtack> getAtacks();
}
