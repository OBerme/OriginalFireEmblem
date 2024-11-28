package entes.ln;

import entes.IEnteEvents;
import entes.md.Monstruo;

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
//		if(monstruo.getState()==ServicioState.Died) {
//			enteEvents.onEnteDies(monstruo);
//		}
	}
	@Override
	public String getStatus() {
		return monstruo.getStatus();
	}
	
	
	
}
