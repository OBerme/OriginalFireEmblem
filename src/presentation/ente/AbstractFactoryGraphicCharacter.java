package presentation.ente;

import entes.md.GraphicPersona;
import entes.md.IEnte;
import entes.md.Persona;
import presentation.main.IAbstractFactoryPMenu;

public class AbstractFactoryGraphicCharacter implements IAbstractFactoryGraphicCharacters{
	
	private IAbstractFactoryNormalCharacter nFactory;
	private IAbstractFactoryPMenu mFactory;
	
	public AbstractFactoryGraphicCharacter(IAbstractFactoryNormalCharacter nFactory, IAbstractFactoryPMenu mFactory) {
		super();
		this.nFactory = nFactory;
		this.mFactory = mFactory;
	}


	@Override
	public IGEnte createEnte(AbstractFactoryGraphicCharacterEnums ente) {
		// TODO Auto-generated method stub
		if(AbstractFactoryGraphicCharacterEnums.G_OSCAR_NORMAL.equals(ente)) {
			IEnte oEnte = nFactory.createEnte(ente.getCharacter());
			return new GraphicPersona((Persona)oEnte, 
					ente.getPathImage(),
					mFactory.createMenuEnte(oEnte));
		}
		else if(AbstractFactoryGraphicCharacterEnums.G_JIJI_NORMAL.equals(ente)) {
			IEnte oEnte = nFactory.createEnte(ente.getCharacter());
			return new GraphicPersona((Persona)oEnte, 
					ente.getPathImage(),
					mFactory.createMenuEnte(oEnte));
		}
		return null;
		
	}

}
