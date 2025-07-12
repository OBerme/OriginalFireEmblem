package presentation.GAtack;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import acciones.md.ataque.Tipo;
import md.range.FigureTriangleEnum;
import md.range.Rombo;
import md.range.Square;
import md.range.Triangle;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.map.IGraphicMapAtack;

public class AbstractFactoryGraphicAtack implements IAbstractFactoryGraphicAtack{
	private IGraphicMapAtack map;
	private IAbstractFactoryNormalAtack factory;
	private IShowAtackDistance showAtacksDistan;
	private IShowAtackCached sACached;
	private IMouseHoverSubject hoverSubject;
	
	public AbstractFactoryGraphicAtack(IGraphicMapAtack map,
			IAbstractFactoryNormalAtack factory,IShowAtackDistance showAtacksDistan,IMouseHoverSubject hoverSubject,IShowAtackCached sACached) {
		super();
		this.map = map;
		this.factory = factory;
		this.showAtacksDistan = showAtacksDistan;
		this.hoverSubject = hoverSubject;
		this.sACached = sACached;
	}

	@Override
	public PGraphicAtack createAtack(AbstractFactoryAtackEnums atack) {
		// TODO Auto-generated method stub
		if(atack.equals(AbstractFactoryAtackEnums.FIRE_GUN_NORMAL)) {
			return new PGraphicDistanceAtack((Ataque)factory.createAtack(atack),
					(IGraphicMapAtack)map, new Triangle(1, map, FigureTriangleEnum.RIGHT),
					showAtacksDistan, 2, hoverSubject,sACached);
		}
		else if(atack.equals(AbstractFactoryAtackEnums.PUNCH_RIBS_NORMAL)){
			return new PGraphicMeleAtack((Ataque)factory.createAtack(atack),
					(IGraphicMapAtack)map, new Square(0, map), showAtacksDistan);
		}
		else if(atack.equals(AbstractFactoryAtackEnums.HIT_GARRA_NORMAL)){
			return new PGraphicMeleAtack(
					(Ataque)factory.createAtack(atack),
					(IGraphicMapAtack)map, new Square(0, map), showAtacksDistan);
		}
		else if(atack.equals(AbstractFactoryAtackEnums.MAGICAL_NORMAL)){
			return new PGraphicDistanceAtack(
						(Ataque)factory.createAtack(atack),					
							(IGraphicMapAtack)map,
							new Triangle(1, map, FigureTriangleEnum.RIGHT), showAtacksDistan,2, hoverSubject,sACached);
		}
		return null;
	}
	
	
	
	
	
}
