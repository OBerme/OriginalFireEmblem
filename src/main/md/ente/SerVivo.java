package main.md.ente;

import main.md.group.Group;
import main.md.group.Groupable;

public class SerVivo extends Ente implements Groupable{
	protected Estado estado;
	private Group group;
	
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

	@Override
	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return super.isDied();
	}

	@Override
	public Group getGroup() {
		return this.group;
	}
}
