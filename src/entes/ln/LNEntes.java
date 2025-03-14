package entes.ln;
import java.util.ArrayList;
import java.util.List;

import WebConnection.XML.Util.ln.LNXmlStack;
import acciones.md.ataque.*;
import entes.IEnteEvents;
import entes.md.Ente;
import entes.md.IEnte;

public class LNEntes implements ILNEntes, IEnteEvents{
	protected IEnteEvents[] enteEvents;
	private List<IEnte> entes;
	
	
	public LNEntes(IEnteEvents[] enteEvents) {
		this.entes = new ArrayList<>();
		this.enteEvents = enteEvents; //TODO to change
	}
	
	
	public void reducirHp(IEnte ente, int damage) {
		if(ente.getHp() < damage) {
			ente.setHp(0);
			onEnteDiesEnteEvents(ente);
		}
			
		else {
			ente.setHp(ente.getHp() - damage);
			onEnteReciveAtackEvents(ente);
		}
			
	}
	
	public void addEnte(IEnte ente) {
		this.entes.add(ente);
	}
	
	private void onEnteDiesEnteEvents(IEnte ente) {
		for(IEnteEvents nEnteEvents : this.enteEvents) {
    		nEnteEvents.onEnteDies(ente);
    	}
	}
	
	private void onEnteReciveAtackEvents(IEnte ente) {
		for(IEnteEvents nEnteEvents : this.enteEvents) {
    		nEnteEvents.onEnteReciveAtack(ente);
    	}
	}
	
	public void onEnteDies(IEnte ente) {
    	if(entes.contains(ente)) {
    		entes.remove(ente);
    	}
    }

	@Override
	public void onEnteReciveAtack(IEnte ente) {
		// TODO Auto-generated method stub
		
	}
	
	


	//Pre: the ente should have a valid numb of an ente in the game
	//Post: it will return the ente that has the same numb, null if the ente is not in the game
	
	public IEnte getEnte(IEnte ente) {
		// TODO Auto-generated method stub
		if(entes.contains(ente)) {
			for(IEnte nEnte : entes) {
				if(nEnte.equals(ente)) {
					return nEnte;
				}
			}
		}
		return null; 
	}

	@Override
	public void onEnteChangeHp(IEnte ente) {
		IEnte nEnte = getEnte(ente);
		if(nEnte != null) {
			nEnte.setHp(ente.getHp());
			onEnteReciveAtackEvents(nEnte);
		}
		
	}

	@Override
	public void changeEnte(IEnte ente) {
		IEnte nEnte = getEnte(ente);
		if(nEnte != null) {
			nEnte.setHp(ente.getHp());
			for(IEnteEvents nEnteEvents : this.enteEvents) {
				if(!(nEnteEvents instanceof LNXmlStack))
					nEnteEvents.onEnteReciveAtack(nEnte);	
	    	}
		}
		
	}



	
		
}
