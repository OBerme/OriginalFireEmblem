package presentation.map;

import entes.md.SerVivo;
import mapa.md.IPositionable;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.IObserver;

public class LNGraphicMapInteger implements IObserver{
	private GraphicMapInteger gMap;
	private IPPPositionSubjectData subject;
	private GraphicPositionInteger sPosition;
	public LNGraphicMapInteger(GraphicMapInteger gMap, IPPPositionSubjectData subject) {
		super();
		this.gMap = gMap;
		this.subject = subject;
	}
	

	@Override
	public void update() {
		sPosition = (GraphicPositionInteger)subject.getPosi();
		
		
	}
	
}
