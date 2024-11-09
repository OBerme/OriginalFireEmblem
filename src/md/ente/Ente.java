package md.ente;

public  class Ente{
	protected int hp;
	protected String name;
	public Ente(int hp, String name) {
		this.hp=hp;
		this.name=name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "E";
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp=hp;
	}
	public String getName() {
		return this.name;
	}
}
