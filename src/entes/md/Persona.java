package entes.md;



import java.util.List;

import acciones.md.ataque.Ataque;
import entes.Atacable;
import entes.Estado;
import group.md.Group;
import group.md.Groupable;

public class Persona extends SerVivo implements Atacable{
	private List<Ataque> atacks;
	public Persona(int hp, String name,String shortName, Estado estado, int speed, List<Ataque> atacks) {
		super(hp, name,shortName, estado, speed);
		this.atacks = atacks;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		
		return super.equals(obj);
	
	}
	

	public String getStatus() {
		// TODO Auto-generated method stub
		return "Persona " + this.name 
				+ "\nHealth: " + this.hp
				+ "\nStatus: " + this.estado.getTipoEstado().toString()
				+ "\nNum Turns: " + this.numTurns;
	}

	@Override
	public List<Ataque> getAtacks() {
		return List.copyOf(atacks);
	}

}

