package presentation.GAtack;

import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import acciones.md.ataque.IAtack;
import mapa.md.IPosition;
import presentation.map.IGraphicMapAtack;
import presentation.map.IGraphicMapAtackDistance;
import presentation.map.ILNGraphicMapIntegerAtackDistance;

@objid ("70eb51be-97e2-4121-92e2-154324372516")
public interface IPGraphicAtack extends IAtack{
    @objid ("aa8604a6-7a95-4091-be66-3b8674c4f5ec")

	public List<IPosition<Integer, Integer>> getActivatePositions(IPosition<Integer, Integer> posi) ;

    public void activatePositions(IPosition<Integer, Integer> lastPosition);

    
    
	
}
