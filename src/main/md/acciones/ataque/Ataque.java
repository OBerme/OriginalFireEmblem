package main.md.acciones.ataque;

import main.md.acciones.Accion;
import main.md.ente.Ente;

public class Ataque extends Accion {
    private int fuerza;
    private Tipo tipo;

    public Ataque(String name, int fuerza, Tipo tipo) {
        super(name);
        this.fuerza = fuerza;
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    public int getDamage() {
    	return fuerza;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(obj == null) return false;
    	
    	if(obj instanceof Ataque) {
    		Ataque atObj = (Ataque) obj;
        	// TODO Auto-generated method stub
    		boolean equalObj =super.equals(obj);
        	return equalObj  && atObj.getTipo().equals(getTipo());
    	}

		return false;
    }
}