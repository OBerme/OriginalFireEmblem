package main.md.ente;


public class Monstruo extends SerVivo {
	public Monstruo(int hp, String name,String shortName, Estado estado) {
		super(hp, name,shortName, estado);
		// TODO Auto-generated constructor stub
	}
	public void ataqueEspecial() {
		System.out.println(name + "usa un ataque especial");
	}

}
