package entes.md;

import java.awt.Image;

import entes.Estado;
import menu.md.Menu;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;
import turner.md.Actionable;

public abstract class GraphicSerVivo extends GraphicEnte implements Menuable, Actionable{
	protected IPMenu<Integer, Integer> menu;
	
	public GraphicSerVivo(Ente ente, String pathImage, IPMenu<Integer, Integer> menu) {
		super(ente, pathImage);
		this.menu = menu;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IPMenu<Integer, Integer> getMenu() {
		// TODO Auto-generated method stub
		return menu;
	}


	@Override
	public int getNumActions() {
		// TODO Auto-generated method stub
		return ((SerVivo)ente).getNumActions();
	}

	@Override
	public boolean hasActions() {
		// TODO Auto-generated method stub
		return ((SerVivo)ente).hasActions();
	}

	@Override
	public void subtractNumActions(int numActions) {
		((SerVivo)ente).subtractNumActions(numActions);
		
	}

	@Override
	public void resetNumActions() {
		((SerVivo)ente).resetNumActions();
		
	}

	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return ((SerVivo)ente).canMove();
	}



	
}
