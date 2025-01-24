package entes.md;

import java.util.List;

import acciones.md.ataque.Ataque;
import entes.Estado;
import menu.md.Menu;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;

public class GraphicMonstruo extends Monstruo implements Menuable, IDrawable{

	public GraphicMonstruo(int hp, String name, String shortName, Estado estado, int speed, List<Ataque> atacks) {
		super(hp, name, shortName, estado, speed, atacks);
		// TODO Auto-generated constructor stub
	}



}
