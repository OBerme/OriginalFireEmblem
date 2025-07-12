package presentation.GAtack;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;

public interface IAbstractFactoryNormalAtack extends IAbstractFactoryAtack {
	Ataque createAtack(AbstractFactoryAtackEnums atack);
}
