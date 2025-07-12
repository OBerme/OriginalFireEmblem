package presentation.ente;

import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.Monstruo;
import turner.md.enums.TurnerEnumConstant;

public enum AbstractFactoryCharacterEnums {
	
	
	OSCAR_NORMAL(1500, "Bluesky","B", 
			StateSerVivo.NORMAL, TurnerEnumConstant.SPEED_DIVIDER.getCost(), 
			AbstractFactoryCharacters.DEFAULT_RANGE),
	JIJI_NORMAL(2700, "Jiji","J", 
			StateSerVivo.NORMAL, TurnerEnumConstant.SPEED_DIVIDER.getCost(), 
			AbstractFactoryCharacters.DEFAULT_RANGE);
	
	private final int health;
    private final String name;
	private final String shortName;
	private final StateSerVivo state;
	
    private final int speed; 
    private final int range;
    
    
	private AbstractFactoryCharacterEnums(int health, String name, String shortName, StateSerVivo state, int speed,
			int range) {
		this.health = health;
		this.name = name;
		this.shortName = shortName;
		this.state = state;
		this.speed = speed;
		this.range = range;
	}
	
	public int getHealth() {
		return health;
	}
	public String getName() {
		return name;
	}
	public String getShortName() {
		return shortName;
	}
	public StateSerVivo getState() {
		return state;
	}
	public int getSpeed() {
		return speed;
	}
	public int getRange() {
		return range;
	}
    

}
