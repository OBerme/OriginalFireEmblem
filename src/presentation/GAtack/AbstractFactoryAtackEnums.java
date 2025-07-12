package presentation.GAtack;

import acciones.md.ataque.Tipo;

public enum AbstractFactoryAtackEnums {
	FIRE_GUN_NORMAL("Gun atack", 1, 50000, Tipo.FUEGO),
	PUNCH_RIBS_NORMAL("Punietaso en las costillas", 2, 5000, Tipo.FUEGO),
	MAGICAL_NORMAL("Magical atack", 3, 50000, Tipo.FUEGO),
	HIT_GARRA_NORMAL("Garrazo en las costillas",4, 300, Tipo.FUEGO);
	

    private final String nameAtack;
    private final int numAtack; 
    private final int damage;
    private final Tipo type;

    private AbstractFactoryAtackEnums(String nameAtack, int numAtack, int damage, Tipo type) {
		this.nameAtack = nameAtack;
		this.numAtack = numAtack;
		this.damage = damage;
		this.type = type;
	}

	@Override
    public String toString() {
        return nameAtack + "," + numAtack;
    }
    
    public String getName() {
    	return nameAtack;
    }
    
    public int getNumAtack() {
    	return numAtack;
    }
    

	public String getNameAtack() {
		return nameAtack;
	}

	public Tipo getType() {
		return type;
	}

	public int getDamage() {
		return damage;
	}

}
