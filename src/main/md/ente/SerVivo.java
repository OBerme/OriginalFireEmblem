package main.md.ente;

public class SerVivo extends Ente{
	protected Estado estado;
	public SerVivo(int hp, String name,String shortName,  Estado estado) {
		super(hp, name, shortName);
		this.estado = estado;
		// TODO Auto-generated constructor stub
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp=hp;
	}
	public String getName(){
		return this.name;
	}
}
