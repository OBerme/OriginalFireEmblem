package main.md.ente;

import main.md.group.Groupable;

public class Monstruo extends SerVivo {
	public Monstruo(int hp, String name,String shortName, Estado estado, int speed) {
		super(hp, name,shortName, estado, speed);
		// TODO Auto-generated constructor stub
	}
	public void ataqueEspecial() {
		System.out.println(name + "usa un ataque especial");
	}

}
