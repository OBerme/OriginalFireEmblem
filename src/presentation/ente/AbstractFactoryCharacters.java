package presentation.ente;

import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.Monstruo;
import entes.md.Persona;
import mapa.md.IMapa;
import md.range.Rombo;
import md.range.Square;
import presentation.GAtack.PGraphicDistanceAtack;
import presentation.GAtack.PGraphicMeleAtack;
import presentation.map.IGraphicMapAtack;
import turner.md.enums.TurnerEnumConstant;

public class AbstractFactoryCharacters {
	private static AbstractFactoryCharacters singleton;
	
	private static final int DEFAULT_RANGE = 2;
	private static List<IAtack> ataquesN, ataquesM ;
	private IMapa<Integer, Integer> map;
	
	
	public AbstractFactoryCharacters(IGraphicMapAtack map) {
		
		if(singleton == null) {
			singleton = this;
			
			ataquesN = new ArrayList<IAtack>();
			
			ataquesN.add(new PGraphicDistanceAtack(
					new Ataque(1, "Gun atack", 50000, Tipo.FUEGO),
						(IGraphicMapAtack)map, new Square(0, map),2));
			
			ataquesN.add(new PGraphicMeleAtack(
					new Ataque(2, "Punietaso en las costillas", 200, Tipo.AGUA),
						(IGraphicMapAtack)map, new Square(0, map)));
			
			ataquesM = new ArrayList<IAtack>();
			
			ataquesM.add(new Ataque(1, "Magical atack", 50000, Tipo.FUEGO));
			ataquesM.add(new Ataque(2, "Garrazo en las costillas", 300, Tipo.FUEGO));
		}
		
	}
	
	public static Ente createOscar() {
		
		
		// TODO Auto-generated method stub
		return new Persona(200, "Oscar", "O", 
				new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),DEFAULT_RANGE, 
				ataquesN);
	}
	

	public static Ente createJiji() {
		
		return new Persona(700, "Joji", "J", 
				new Estado(StateSerVivo.NORMAL),
				TurnerEnumConstant.SPEED_DIVIDER.getCost(),
				DEFAULT_RANGE,
				ataquesM);
	}

	public static Ente createUndyne() {

		return new Monstruo(1500, "Undyne", "U", 
				new Estado(StateSerVivo.NORMAL),
				TurnerEnumConstant.SPEED_DIVIDER.getCost(),
				DEFAULT_RANGE,
				ataquesN);
	}
	
	public static Ente createAsgore() {

		return new Monstruo(2700, "Asgore", "A", 
				new Estado(StateSerVivo.NORMAL),
				TurnerEnumConstant.SPEED_DIVIDER.getCost(),
				DEFAULT_RANGE,
				ataquesN);
	}

}
