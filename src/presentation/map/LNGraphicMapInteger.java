package presentation.map;

import entes.md.SerVivo;
import mapa.ln.INLMapa;
import mapa.md.IPositionable;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.IObserver;

public class LNGraphicMapInteger {
	protected IGraphicMap gMap;
	
	
	protected INLMapa<Integer, Integer> lnMap;
	
	public LNGraphicMapInteger(IGraphicMap gMap,
			INLMapa<Integer, Integer> lnMap) {
		super();
		this.gMap = gMap;
		this.lnMap = lnMap;
	}
	

}
