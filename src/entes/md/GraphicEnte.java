package entes.md;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import mapa.md.IPositionable;
import presentation.ente.IGEnte;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;
import presentation.main.PDefaultValues;

public class GraphicEnte implements IDrawable, IPositionable, IGEnte {
	protected ImageIcon imageIcon;
	protected String pathImage;
	protected Ente ente;
	
	public GraphicEnte(Ente ente, String pathImage) {
		super();
		this.ente = ente;
		this.pathImage = pathImage;
		this.imageIcon = new ImageIcon(pathImage);
	}
	
	public Ente getEnte() {
		return ente;
	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return pathImage;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ente.toString();
	}

	public JComponent getRepresentation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon getImage() {
		return imageIcon;
	}

}
