package entes;

import java.util.List;

import acciones.md.ataque.Ataque;

public interface Atacable {
	//Pre: ----
	//Post: se devolvera una lista con ataques variables, nunca sera nula pero si puede estar vacia
	public List<Ataque> getAtacks();
}
