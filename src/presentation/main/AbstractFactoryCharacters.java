package presentation.main;

import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.Monstruo;
import entes.md.Persona;
import turner.md.enums.TurnerEnumConstant;

public class AbstractFactoryCharacters {
	private static AbstractFactoryCharacters singleton;
	
	private static final int DEFAULT_RANGE = 2;
	private static List<Ataque> ataquesN, ataquesM ;
	
	private AbstractFactoryCharacters() {
		ataquesN = new ArrayList<Ataque>();
		ataquesN.add(new Ataque(1, "Gun atack", 50000, Tipo.FUEGO));
		ataquesN.add(new Ataque(2, "Punietaso en las costillas", 200, Tipo.AGUA));
		
		ataquesM = new ArrayList<Ataque>();
		ataquesM.add(new Ataque(1, "Magical atack", 50000, Tipo.FUEGO));
		ataquesM.add(new Ataque(2, "Garrazo en las costillas", 300, Tipo.FUEGO));
	}
	
	public static Ente createOscar() {
		
		checkSingleton();
		
		// TODO Auto-generated method stub
		return new Persona(200, "Oscar", "O", 
				new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),DEFAULT_RANGE, 
				ataquesN);
	}
	
	private static void checkSingleton() {
		if(singleton  == null)
			singleton = new AbstractFactoryCharacters();
	}

	public static Ente createJiji() {
		checkSingleton();
		
		return new Persona(700, "Joji", "J", 
				new Estado(StateSerVivo.NORMAL),
				TurnerEnumConstant.SPEED_DIVIDER.getCost(),
				DEFAULT_RANGE,
				ataquesM);
	}

	public static Ente createUndyne() {
		checkSingleton();

		return new Monstruo(1500, "Undyne", "U", 
				new Estado(StateSerVivo.NORMAL),
				TurnerEnumConstant.SPEED_DIVIDER.getCost(),
				DEFAULT_RANGE,
				ataquesN);
	}
	
	public static Ente createAsgore() {
		checkSingleton();

		return new Monstruo(2700, "Asgore", "A", 
				new Estado(StateSerVivo.NORMAL),
				TurnerEnumConstant.SPEED_DIVIDER.getCost(),
				DEFAULT_RANGE,
				ataquesN);
	}

}
