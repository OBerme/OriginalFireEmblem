package presentation.ente;

import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.IEnte;
import entes.md.Monstruo;
import entes.md.Persona;
import mapa.md.IMapa;
import md.range.Rombo;
import md.range.Square;
import presentation.GAtack.AbstractFactoryAtackEnums;
import presentation.GAtack.IAbstractFactoryAtack;
import presentation.GAtack.PGraphicDistanceAtack;
import presentation.GAtack.PGraphicMeleAtack;
import presentation.map.IGraphicMapAtack;
import turner.md.enums.TurnerEnumConstant;

public class AbstractFactoryCharacters
	implements IAbstractFactoryNormalCharacter{	
	public static final int DEFAULT_RANGE = 2;
	
	private IAbstractFactoryAtack factory;
	
	public AbstractFactoryCharacters(IAbstractFactoryAtack factory) {
		this.factory = factory;
	}
	
	@Override
	public IEnte createEnte(AbstractFactoryCharacterEnums ente) {
		
		
		if(AbstractFactoryCharacterEnums.OSCAR_NORMAL.equals(ente)) {
			List<IAtack> atacks = new ArrayList<IAtack>();
			atacks.add(factory.createAtack(AbstractFactoryAtackEnums.FIRE_GUN_NORMAL));
			atacks.add(factory.createAtack(AbstractFactoryAtackEnums.PUNCH_RIBS_NORMAL));
			
			return new Persona(ente.getHealth(),
					ente.getName(), 
					ente.getShortName(), 
					new Estado(ente.getState()),ente.getSpeed(),
					ente.getRange(), 
					atacks);
		}
		else if (AbstractFactoryCharacterEnums.JIJI_NORMAL.equals(ente)) {
			List<IAtack> atacks = new ArrayList<IAtack>();
			atacks.add(factory.createAtack(AbstractFactoryAtackEnums.HIT_GARRA_NORMAL));
			atacks.add(factory.createAtack(AbstractFactoryAtackEnums.MAGICAL_NORMAL));
			

			return new Persona(ente.getHealth(),
					ente.getName(), 
					ente.getShortName(), 
					new Estado(ente.getState()),ente.getSpeed(),
					ente.getRange(), 
					atacks);
		}
		
		
		return null;
	}

}

