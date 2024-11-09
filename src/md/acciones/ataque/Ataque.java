package md.acciones.ataque;

import md.acciones.Accion;
import md.ente.Ente;

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
}