package main.md.acciones;

import main.md.ente.Ente;

public abstract class Accion {
	protected String name;
	protected Ente ente;

    public Accion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Pueden que nos cambien la direccion del ataque
    public void setEnte(Ente ente) {
    	this.ente = ente;
    }
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	
    	if(obj != null && obj instanceof Accion) {
    		return this.name.equals( ( (Accion) obj ).getName());	
    	}
    	return false;
    	
    }
    
}