package presentation.GAtack;

import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import acciones.md.ataque.Ataque;
import mapa.md.IPosition;
import md.range.IFigure;
import presentation.MouseHoverObserver.IMouseHoverObserver;
import presentation.map.IGraphicMap;
import presentation.map.IGraphicMapAtack;

@objid ("65d7d21a-c2fc-4338-a70f-475f333b6320")
public abstract  class PGraphicAtack implements IPGraphicAtack{
    @objid ("fca6ce00-0274-47a8-8c65-0d01a112842c")
    protected Ataque atack;
    protected IGraphicMapAtack map;
    protected IFigure<Integer, Integer> figure;
    protected IShowAtack atackShowable;
    
    public PGraphicAtack(Ataque atack, IGraphicMapAtack map, IFigure<Integer, Integer> figure ,IShowAtack atackShowable) {
		super();
		this.atack = atack;
		this.map = map;
		this.figure = figure;
		this.atackShowable = atackShowable;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return atack.getName();
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return atack.getDamage();
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return atack.getCost();
	}
}
