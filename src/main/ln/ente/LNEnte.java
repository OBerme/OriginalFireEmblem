package main.ln.ente;
import main.md.acciones.ataque.*;
import main.md.ente.Ente;
import main.md.ente.IEnteEvents;

public abstract class LNEnte {
	protected IEnteEvents enteEvents;
	public LNEnte(IEnteEvents enteEvents) {
		this.enteEvents =  enteEvents;
	}
	public abstract void reducirHp(int damage);
	public abstract String  getStatus();
}
