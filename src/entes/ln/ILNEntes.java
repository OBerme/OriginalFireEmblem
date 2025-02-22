package entes.ln;

import entes.IEnteEvents;
import entes.md.Ente;
import entes.md.IEnte;

public interface ILNEntes extends IEnteEvents{
	void reducirHp(IEnte ente, int damage);
	void addEnte(IEnte ente);
	void changeEnte(IEnte ente);
	public IEnte getEnte(IEnte ente);
}
