package entes.md;

import java.util.List;

import acciones.md.ataque.IAtack;
import entes.Atacable;
import entes.Estado;
import menu.md.Menu;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;
import turner.md.Actionable;

public class GraphicMonstruo extends GraphicSerVivo implements Atacable{

	public GraphicMonstruo(Monstruo mons, String pathImage, PMenu menu) {
		super(mons, pathImage, menu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IAtack> getAtacks() {
		// TODO Auto-generated method stub
		return ((Monstruo)ente).getAtacks();
	}

	
}
