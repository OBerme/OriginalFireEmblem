package entes.md;

import mapa.md.IPositionable;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;

public class GraphicEnte implements IDrawable, IPositionable {
	
	protected String pathImage;
	protected Ente ente;
	
	public GraphicEnte(Ente ente, String pathImage) {
		super();
		this.ente = ente;
		this.pathImage = pathImage;
	}
	
	public Ente getEnte() {
		return ente;
	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return pathImage;
	}

}
