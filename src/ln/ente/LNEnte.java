package ln.ente;
import md.acciones.ataque.*;
import md.ente.Ente;
import md.ente.IEnteEvents;

public abstract class LNEnte {
	protected IEnteEvents enteEvents;
	public LNEnte(IEnteEvents enteEvents) {
		this.enteEvents =  enteEvents;
	}
	public abstract void reducirHp(int damage);
}
