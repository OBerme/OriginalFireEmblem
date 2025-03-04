package presentation.map.jbutton;

import entes.md.GraphicEnte;
import presentation.ente.AbstractFactoryCharacters;
import presentation.ente.IGEnte;
import presentation.graphicOptions.IShowMenus;

public class AbstractFactoryJButtonActions {
	private static AbstractFactoryJButtonActions singleton = checkSingleton();
	private static JButtonActionVoid voidAction;
	
	private AbstractFactoryJButtonActions() {
		voidAction = new JButtonActionVoid();
	}
	
	
	public static IJButtonAction getVoidAction() {
		return voidAction;
	}
	
	private static AbstractFactoryJButtonActions checkSingleton() {
		return new AbstractFactoryJButtonActions();
	}
	
	public static IJButtonAction getEnteAction(IPGraphicPositionInteger pGPI,
			IGEnte gEnte, IShowMenus isMenu) {
//		return new JButtonActionAtack(pGPI, gEnte, isMenu);
		return new JButtonActionAtack(pGPI, gEnte, isMenu);
	}

}
