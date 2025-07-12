package presentation.map.jbutton;

import presentation.ente.IGEnte;

public interface IAbstractFactoryJButtonActions {

	IJButtonAction getEnteAction(IPGraphicPositionInteger pGPI, IGEnte gEnte);

	IJButtonAction getVoidAction();

}
