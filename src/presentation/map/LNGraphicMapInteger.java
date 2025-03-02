package presentation.map;

import entes.md.SerVivo;
import mapa.ln.INLMapa;
import mapa.md.IPositionable;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.IObserver;

public class LNGraphicMapInteger implements IObserver{
	protected IGraphicMap gMap;
	protected IPPPositionSubjectData subject;
	protected GraphicPositionInteger sPosition;
	protected INLMapa<Integer, Integer> lnMap;
	
	public LNGraphicMapInteger(IGraphicMap gMap, IPPPositionSubjectData subject, 
			INLMapa<Integer, Integer> lnMap) {
		super();
		this.gMap = gMap;
		this.subject = subject;
		this.lnMap = lnMap;
	}
	

	@Override
	public void update() {
		sPosition = (GraphicPositionInteger)subject.getPosi();
		
		
	}
	
}
