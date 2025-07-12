package entes.md;

import java.util.List;

import acciones.md.ataque.IAtack;
import entes.Atacable;
import entes.Estado;
import menu.md.Menu;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

public class GraphicPersona extends GraphicSerVivo implements Atacable{

	public GraphicPersona(Persona persona, String pathImage, IPMenu<Integer, Integer> menu) {
		super(persona, pathImage, menu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IAtack> getAtacks() {
		// TODO Auto-generated method stub
		return ((Persona)ente).getAtacks();
	}

	

}
