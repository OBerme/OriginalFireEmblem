package entes.md;

import java.awt.Image;

import entes.Estado;
import menu.md.Menu;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;
import presentation.menu.PMenu;

public abstract class GraphicSerVivo extends GraphicEnte implements Menuable{
	protected PMenu menu;
	
	public GraphicSerVivo(Ente ente, String pathImage, PMenu menu) {
		super(ente, pathImage);
		this.menu = menu;
		// TODO Auto-generated constructor stub
	}

	public PMenu getMenu() {
		return menu;
	}
	
}
