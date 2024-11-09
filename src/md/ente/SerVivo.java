package md.ente;

public class SerVivo extends Ente{
	private Estado estado;
	public SerVivo(int hp, String name, Estado estado) {
		super(hp, name);
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
