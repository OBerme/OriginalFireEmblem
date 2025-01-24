package entes.md;

import java.util.List;

import acciones.md.ataque.Ataque;
import entes.Atacable;
import entes.Estado;
import group.md.Groupable;

public class Monstruo extends SerVivo implements Atacable{
	private List<Ataque> atacks;
	//Pre: atacks should be a empty list if it hasen't atacks
	//Post: it will build the new class
	public Monstruo(int hp, String name,String shortName, Estado estado, int speed,List<Ataque> atacks) {
		super(hp, name,shortName, estado, speed);
		this.atacks = atacks;
		// TODO Auto-generated constructor stub
	}
	public void ataqueEspecial() {
		System.out.println(name + "usa un ataque especial");
	}
	
	//Pre: ----
	//Post: se devolvera una lista con ataques variables, nunca sera nula pero si puede estar vacia
	@Override
	public List<Ataque> getAtacks() {
		return List.copyOf(atacks);
	}

}
