package entes.ln;

import entes.IEnteEvents;
import entes.md.Persona;

public class LNPersona extends LNSerVivo{
	private Persona persona;
	
	
	public LNPersona(IEnteEvents ievent) {
		super(ievent);
		this.persona = persona;
	}
	
	public void reducirHp(int damage) {
//		if(!persona.esquiva()) {
//			persona.setHP(persona.getHp() - damage);
//			if(persona.getState() == ServivoState.Died) {
//
//				enteEvents.onEnteDies(persona);
//			}	
//		}
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		
		return persona.getStatus();
	}
	

}
