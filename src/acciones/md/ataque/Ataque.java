package acciones.md.ataque;

import acciones.md.Accion;
import entes.md.Ente;
import turner.md.enums.TurnerEnumConstant;

public class Ataque extends Accion {
	private int num;
    private int fuerza;
    private Tipo tipo;
    private int cost;
    
    public Ataque(int num ,String name, int fuerza, Tipo tipo) {
      this(num,name, fuerza, tipo, TurnerEnumConstant.MOVE_COST.getCost());
    }
    
    public Ataque(int num ,String name, int fuerza, Tipo tipo, int cost) {
        super(name);
        this.num = num;
        this.fuerza = fuerza;
        this.tipo = tipo;
        this.cost = cost;
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
    
    public int getNum() {
		return num;
	}

	public int getCost() {
		return cost;
	}

	@Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return num + "º " + name + " fuerza  "+ fuerza + " tipo " + tipo;
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