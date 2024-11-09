package ML.Ente;
import MD.Acciones.Ataque.Ataque;
import md.ente.Ente;

public abstract class LNEnte {
	protected IEnteEvents enteEvents;
	public LNEnte(IEnteEvents enteEvents) {
		this.enteEvents =  enteEvents;
	}
	public abstract void reducirHp(int damage);
}
