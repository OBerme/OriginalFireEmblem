package presentation.map;

import java.util.ArrayList;
import java.util.List;

import entes.md.GraphicEnte;
import entes.md.IEnte;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.INLMapa;
import mapa.md.IPosition;
import mapa.md.IPositionForEnte;
import presentation.ente.IGEnte;
import presentation.graphicOptions.IShowMenus;
import presentation.map.jbutton.AbstractFactoryJButtonActions;
import presentation.map.jbutton.IJButtonAction;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.IPGraphicPositionInteger;

public class LNGraphicMapIntegerEnte extends LNGraphicMapInteger 
	implements ILNGraphicMapIntegerEnte{
	protected IShowMenus menuContro;

	public LNGraphicMapIntegerEnte(IGraphicMapIntegerEnte gMap,
			ILNMapaMatrixEntes lnMap, IShowMenus menuContro) {
		super(gMap, lnMap);
		// TODO Auto-generated constructor stub
	}



	@Override
	public IGEnte getGEntePosition(IPosition<Integer, Integer> posicion) {
		// TODO Auto-generated method stub
		return ((IGraphicMapIntegerEnte)gMap).getEntePosition(posicion);
	}
	


	@Override
	public void moveEnte(IGEnte gEnte, int x, int y) {
		if(gMap.hasPosition(x, y)) {
			ILNMapaMatrixEntes ilnMapEnte =  (ILNMapaMatrixEntes)lnMap;
			if(ilnMapEnte.isEnteInMap(gEnte)){
				IPosition<Integer, Integer> lastPosi =  ilnMapEnte.getPositionEnte(gEnte);
				
				((IGraphicMapIntegerEnte)gMap).moveEnte(gEnte, x, y, 
						lastPosi.getX(), lastPosi.getY());
			}
			else 
				((IGraphicMapIntegerEnte)gMap).putEnteOnPosi(gEnte, x, y);
			
			
			ilnMapEnte.moverEnte(gEnte.getEnte(), x, y);			 
		}
	}
	


}

