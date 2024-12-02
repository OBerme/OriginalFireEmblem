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
		if(ente.getHp() < damage) {
			ente.setHp(0);
			onEnteDiesEnteEvents(ente);
		}
			
		else {
			ente.setHp(ente.getHp() - damage);
			onEnteReciveAtackEvents(ente);
		}
			
	}
	
	public void addEnte(Ente ente) {
		this.entes.add(ente);
	}
	
	private void onEnteDiesEnteEvents(Ente ente) {
		for(IEnteEvents nEnteEvents : this.enteEvents) {
    		nEnteEvents.onEnteDies(ente);
    	}
	}
	
	private void onEnteReciveAtackEvents(Ente ente) {
		for(IEnteEvents nEnteEvents : this.enteEvents) {
    		nEnteEvents.onEnteReciveAtack(ente);
    	}
	}
	
	public void onEnteDies(Ente ente) {
    	if(entes.contains(ente)) {
    		entes.remove(ente);
    	}
    }

	@Override
	public void onEnteReciveAtack(Ente ente) {
		// TODO Auto-generated method stub
		
	}
	
	


	//Pre: the ente should have a valid numb of an ente in the game
	//Post: it will return the ente that has the same numb, null if the ente is not in the game
	
	public Ente getEnte(Ente ente) {
		// TODO Auto-generated method stub
		if(entes.contains(ente)) {
			for(Ente nEnte : entes) {
				if(nEnte.equals(ente)) {
					return nEnte;
				}
			}
		}
		return null; 
	}

	@Override
	public void onEnteChangeHp(Ente ente) {
		Ente nEnte = getEnte(ente);
		if(nEnte != null) {
			nEnte.setHp(ente.getHp());
		}
		
	}
		
}
