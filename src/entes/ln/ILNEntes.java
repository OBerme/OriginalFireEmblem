package entes.ln;

import entes.IEnteEvents;
import entes.md.Ente;

public interface ILNEntes extends IEnteEvents{
	void reducirHp(Ente ente, int damage);
	void addEnte(Ente ente);
	void changeEnte(Ente ente);
	public Ente getEnte(Ente ente);
}
