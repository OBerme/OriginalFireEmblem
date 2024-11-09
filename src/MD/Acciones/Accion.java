package MD.Acciones;

import MD.Ente.Ente;

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