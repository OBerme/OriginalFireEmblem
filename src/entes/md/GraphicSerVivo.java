package entes.md;

import java.awt.Image;

import entes.Estado;
import menu.md.Menu;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;

public abstract class GraphicSerVivo extends GraphicEnte implements Menuable{
	protected Menu menu;
	
	public GraphicSerVivo(Ente ente, String pathImage, Menu menu) {
		super(ente, pathImage);
		this.menu = menu;
		// TODO Auto-generated constructor stub
	}

	public Menu getMenu() {
		return menu;
	}
	
}
