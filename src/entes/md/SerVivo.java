package entes.md;

import entes.Estado;
import entes.Movable;
import group.md.Group;
import group.md.Groupable;
import turner.md.Actionable;
import turner.md.enums.TurnerEnumConstant;

public class SerVivo extends Ente implements Groupable, Actionable, Movable{
	protected Estado estado;
	protected Group group;
	protected int numTurns;
	protected int dNumTurns;
	protected boolean hasMoreActions;
	
	public SerVivo(int hp, String name,String shortName,  Estado estado, int speed) {
		super(hp, name, shortName);
		this.estado = estado;
		this.numTurns =  TurnerEnumConstant.getNumTurns(speed);
		this.dNumTurns = numTurns;
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
	
	
	@Override
	public int getNumActions() {
		return  numTurns ;
	}
	@Override
	public boolean hasActions() {
		return getNumActions() != 0 ;
	}
	@Override
	public void subtractNumActions(int numActions) {
		if(numActions > numTurns)
			this.numTurns = 0;
		else 
			this.numTurns -= numActions;		
	}
	@Override
	public void resetNumActions() {
		this.numTurns = dNumTurns;
		
	}
	@Override
	public String getGRepresentation() {
		// TODO Auto-generated method stub
		return numb+"";
	}
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return this.numb;
	}
}
