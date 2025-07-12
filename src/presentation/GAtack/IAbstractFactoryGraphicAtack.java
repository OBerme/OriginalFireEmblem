package presentation.GAtack;

import acciones.md.ataque.IAtack;

public interface IAbstractFactoryGraphicAtack extends IAbstractFactoryAtack{
	PGraphicAtack createAtack(AbstractFactoryAtackEnums atack);
}
