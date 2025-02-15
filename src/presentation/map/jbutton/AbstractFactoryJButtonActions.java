package presentation.map.jbutton;

import entes.md.GraphicEnte;
import presentation.graphicOptions.IShowMenus;
import presentation.main.AbstractFactoryCharacters;

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
	
	public static IJButtonAction getEnteAction(PGraphicPositionInteger pGPI,
			GraphicEnte gEnte, IShowMenus isMenu) {
		return new JButtonActionEnte(pGPI, gEnte, isMenu);
	}

}
