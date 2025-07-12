package presentation.GAtack;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import acciones.md.ataque.Tipo;
import md.range.Rombo;
import presentation.map.IGraphicMapAtack;

public class AbstractFactoryNormalAtack implements IAbstractFactoryNormalAtack {

	@Override
	public Ataque createAtack(AbstractFactoryAtackEnums atack) {
		
//		if(atack.equals(AbstractFactoryAtackEnums.FIRE_GUN_NORMAL)) {
//			return new Ataque(AbstractFactoryAtackEnums.FIRE_GUN_NORMAL.getNumAtack(),
//					AbstractFactoryAtackEnums.FIRE_GUN_NORMAL.getName(),
//					AbstractFactoryAtackEnums.FIRE_GUN_NORMAL.getDamage(),
//					AbstractFactoryAtackEnums.FIRE_GUN_NORMAL.getType());
//		}
//		else if(atack.equals(AbstractFactoryAtackEnums.PUNCH_RIBS_NORMAL)) {
//			return new Ataque(AbstractFactoryAtackEnums.PUNCH_RIBS_NORMAL.getNumAtack(),
//					AbstractFactoryAtackEnums.PUNCH_RIBS_NORMAL.getName(),
//					AbstractFactoryAtackEnums.PUNCH_RIBS_NORMAL.getDamage(),
//					AbstractFactoryAtackEnums.PUNCH_RIBS_NORMAL.getType());
//		}
//		else if()
		return new Ataque(
				atack.getNumAtack(),
				atack.getName(),
				atack.getDamage(),
				atack.getType());
	}
}
