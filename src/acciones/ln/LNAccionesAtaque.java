package acciones.ln;



import java.util.HashMap;

import acciones.md.ataque.Ataque;
import entes.IEnteEvents;
import entes.md.Ente;

public class LNAccionesAtaque extends LNAccion implements ILNAccion{
	private IEnteEvents[] enteEvents;
	private HashMap<Ente, AtaqueDecorator> ataques;

    // Constructor de LNAtaque, acepta un ente y un ataque inicial
    public LNAccionesAtaque(IEnteEvents[] enteEvents) {
        this.ataques = new HashMap<Ente, AtaqueDecorator>();
        this.enteEvents = enteEvents;
    }

    // Método para agregar un nuevo ataque al ataque decorador
    public void appendAtaque(Ente ente, Ataque ataque) {
    	if(this.ataques.containsKey(ente)) {
    		AtaqueDecorator atack =  this.ataques.get(ente);
    		atack = new AtaqueCombinado(ataque, atack);
    		this.ataques.put(ente, atack);
    	}
    	else
    		this.ataques.put(ente, new AtaqueSolo(ataque));
    }
    

    // Pre: The atack should be in the list
    public void removeAtaque(Ente ente, Ataque ataque) {
    	if(ataques.containsKey(ente)) {
    		AtaqueDecorator removeAtack =  getRemoveAtaque(this.ataques.get(ente), ataque);
    		if(removeAtack != null) 
    			this.ataques.put(ente, removeAtack);
    		else
    			this.ataques.remove(ente);
    	}
        
    }
    
    public AtaqueDecorator getRemoveAtaque(AtaqueDecorator node, Ataque ataqueToFind) {
    	if(node instanceof IAtaqueDeterminista) {
    		IAtaqueDeterminista iADeter  = (IAtaqueDeterminista) node;
    		
    		return  ( iADeter.getAtaque().equals(ataqueToFind) ) ? null : node;
    	}
    		
    	else { //Not determinista
    		IAtaqueNoDeterminista iAtaNDeter = (IAtaqueNoDeterminista) node;
			if(iAtaNDeter.getAtaque1().equals(ataqueToFind))
				return iAtaNDeter.getAtaque2();
			else {
				AtaqueDecorator atack2 =  getRemoveAtaque(iAtaNDeter.getAtaque2(), ataqueToFind);
				if(atack2 == null)
					return new AtaqueSolo(iAtaNDeter.getAtaque1());
				
				return node;
			}
    		
    	}
    }
    
    public AtaqueDecorator getAtacks(Ente ente) {
    	return this.ataques.get(ente);
    }
    
    public void doAtacks() {
    	for(Ente nEnte : this.ataques.keySet()) {
    		AtaqueDecorator atack = this.ataques.get(nEnte);
    		int totalDamage = atack.getDamage();
    		nEnte.setHp(nEnte.getHp() - totalDamage);
    		if(nEnte.getHp() == 0) 
    			onEnteDies(nEnte);
    			
    	}
    }
    
    private void onEnteDies(Ente ente) {
    	for(IEnteEvents nEnteEvents : this.enteEvents) {
    		nEnteEvents.onEnteDies(ente);
    	}
    }
}
