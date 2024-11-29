package entes.ln;
import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.*;
import entes.IEnteEvents;
import entes.md.Ente;

public class LNEntes implements ILNEntes, IEnteEvents{
	protected IEnteEvents[] enteEvents;
	private List<Ente> entes;
	
	public LNEntes(IEnteEvents[] enteEvents,List<Ente> entes) {
		if(entes == null)
			this.entes = new ArrayList<>();
		else this.entes = entes;
		
		this.enteEvents =  enteEvents;
	}
	
	public void reducirHp(Ente ente, int damage) {
		if(ente.getHp() < damage)
			ente.setHp(0);
		else
			ente.setHp(ente.getHp() - damage);
		
		if(ente.getHp() == 0) 
			onEnteDiesEnteEvents(ente);
	}
	
	public void addEnte(Ente ente) {
		this.entes.add(ente);
	}
	
	private void onEnteDiesEnteEvents(Ente ente) {
		for(IEnteEvents nEnteEvents : this.enteEvents) {
    		nEnteEvents.onEnteDies(ente);
    	}
	}
	
	public void onEnteDies(Ente ente) {
    	if(entes.contains(ente)) {
    		entes.remove(ente);
    	}
    }
	
}
