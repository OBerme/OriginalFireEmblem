package presentation.GAtack;

import acciones.md.ataque.IAtack;

public interface IAbstractFactoryAtack {
	IAtack createAtack(AbstractFactoryAtackEnums atack);
}
