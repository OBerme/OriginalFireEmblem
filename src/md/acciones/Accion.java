package md.acciones;

import md.ente.Ente;

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
    
}