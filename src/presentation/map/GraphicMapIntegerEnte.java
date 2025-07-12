package presentation.map;

import entes.md.GraphicEnte;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.INLMapa;
import mapa.md.IPosition;
import mapa.md.IPositionable;
import presentation.ente.IGEnte;
import presentation.main.IAbstractFactoryPMenu;
import presentation.map.jbutton.AbstractFactoryJButtonActions;
import presentation.map.jbutton.IAbstractFactoryJButtonActions;
import presentation.map.jbutton.IJButtonAction;
import presentation.map.jbutton.IPGraphicPositionIntegerAtackDistance;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.IPGraphicPositionInteger;

public class GraphicMapIntegerEnte 
	extends GraphicMapInteger implements IGraphicMapIntegerEnte{
	private IAbstractFactoryJButtonActions aFJButtons;
	public GraphicMapIntegerEnte(ILNMapaMatrixEntes map, IPGraphicPositionInteger[][] gPositions,
			int x, int y,IAbstractFactoryJButtonActions aFJButtons) {
		super(map, gPositions, x, y);
		this.aFJButtons =aFJButtons;
	}
	

	@Override
	public void moveEnte(IGEnte gEnte, int lx, int ly, int nx, int ny) {
		if(hasPosition(nx, ny)) {
			IPGraphicPosition<Integer, Integer> lGPosi = (IPGraphicPosition<Integer, Integer>)getGraphicPosition(lx, ly);
			IPGraphicPosition<Integer, Integer> nGPosi = (IPGraphicPosition<Integer, Integer>)getGraphicPosition(nx, ny);
			changePositions(lGPosi, nGPosi);
		}
	}


	@Override
	public IGEnte getEntePosition(IPosition<Integer, Integer> posicion) {
		// TODO Auto-generated method stub
		IPGraphicPosition<Integer, Integer> gPosition =  gPositions[posicion.getX()][posicion.getY()];
		IPositionable something =  gPosition.getgPosition().getSomething();
		
		return something instanceof IGEnte ? (IGEnte) something :  null;
	}


	@Override
	public void putEnteOnPosi(IGEnte gEnte, int x, int y) {
		IPGraphicPositionInteger sGPosi = getGraphicPosition(x, y);
		sGPosi.setAction(aFJButtons.getEnteAction(sGPosi,gEnte));
		sGPosi.setSomething(gEnte);
		
		sGPosi.refreshButton();
		refreshMap();		
	}

}
