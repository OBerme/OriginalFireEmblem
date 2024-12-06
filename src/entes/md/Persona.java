package entes.md;



import entes.Estado;
import group.md.Group;
import group.md.Groupable;

public class Persona extends SerVivo {
	
	public Persona(int hp, String name,String shortName, Estado estado, int speed) {
		super(hp, name,shortName, estado, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return shortName;
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

}

