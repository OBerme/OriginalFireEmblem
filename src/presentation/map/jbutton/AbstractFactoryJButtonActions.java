package presentation.map.jbutton;

import entes.md.GraphicEnte;
import presentation.ente.AbstractFactoryCharacters;
import presentation.ente.IGEnte;
import presentation.graphicOptions.IShowMenus;

public class AbstractFactoryJButtonActions 
		implements IAbstractFactoryJButtonActions{
	
	private static JButtonActionVoid voidAction;
	private IShowMenus isMenu;	
	
	public AbstractFactoryJButtonActions(IShowMenus isMenu) {
		if(voidAction == null) voidAction = new JButtonActionVoid();
		this.isMenu = isMenu;
	}
	
	@Override
	public IJButtonAction getVoidAction() {
		return voidAction;
	}
	
	@Override
	public IJButtonAction getEnteAction(IPGraphicPositionInteger pGPI,
			IGEnte gEnte) {
		
		return new JButtonActionAtack(pGPI, gEnte, isMenu); //TODO for the entes which hasen't atacks
	}

}
