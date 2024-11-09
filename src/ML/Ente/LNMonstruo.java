package ML.Ente;

import MD.Acciones.Ataque.Ataque;
import md.ente.Monstruo;

public class LNMonstruo extends LNSerVivo {
	private Monstruo monstruo;
	public LNMonstruo(IEnteEvents enteEvents,Monstruo monstruo){
		super(enteEvents);
		this.monstruo=monstruo;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reducirHp(int damage) {
		// TODO Auto-generated method stub
		this.monstruo.setHp(this.monstruo.getHp() - damage);
		if(persona.getState()==ServicioState.Died) {
			enteEvents.onEnteDies(monstruo);
		}
	}
}
