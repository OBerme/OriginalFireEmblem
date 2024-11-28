package entes.ln;
import acciones.md.ataque.*;
import entes.IEnteEvents;

public abstract class LNEnte {
	protected IEnteEvents enteEvents;
	public LNEnte(IEnteEvents enteEvents) {
		this.enteEvents =  enteEvents;
	}
	public abstract void reducirHp(int damage);
	public abstract String  getStatus();
}
