package presentation.GAtack;

import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import acciones.md.ataque.Ataque;
import mapa.md.IPosition;
import md.range.IFigure;
import presentation.map.IGraphicMapAtack;
import presentation.map.ILNGraphicMapIntegerAtackDistance;

@objid ("c628ea93-d6f7-4c80-ba27-589215bf373b")
public class PGraphicMeleAtack extends PGraphicAtack {


	public PGraphicMeleAtack(Ataque atack, IGraphicMapAtack map, IFigure<Integer, Integer> figure,
			IShowAtack atackShowable) {
		super(atack, map, figure, atackShowable);
	}

	@Override
	public List<IPosition<Integer, Integer>> getActivatePositions(IPosition<Integer, Integer> posi) {
		return figure.getPositions(map.getPosition(posi.getX()+1, posi.getY()));
	}

	@Override
	public void activatePositions( IPosition<Integer, Integer> lastPosition) {
		atackShowable.activateAtackPositions(getActivatePositions(lastPosition));
		
	}


	
}
