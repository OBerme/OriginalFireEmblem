package entes.md;

import java.io.Serializable;

public  class Ente implements Serializable{
	protected int hp;
	protected String name;
	protected String shortName;
	protected int numb;
	
	public Ente() {	}
	
	public Ente(int numb) {
		this.numb = numb;
	}
	
	public String getShortName() {
		return shortName;
	}

	public Ente(int hp, String name, String shortName) {
		this.hp=hp;
		this.name=name;
		this.shortName = shortName;
	}
	

	public Ente(int hp, String name, String shortName, int numb) {
		this.hp=hp;
		this.name=name;
		this.shortName=shortName;
		this.numb = numb;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ente " + this.name 
				+ "\nHealth: " + this.hp 
				+ "\nNumb: " + this.numb ;
	}
	
	
	public String getStatus() {
		// TODO Auto-generated method stub
		return "Ente " + this.name 
				+ "\nHealth: " + this.hp;
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
	
	public int getNumb() {
		return numb;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}
	
	public boolean isDied() {
		return this.hp <= 0;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(obj instanceof Ente) {
			Ente eObj = (Ente) obj;
			return eObj.getName().equals(getName()) 
					&& eObj.getShortName().equals(getShortName()) 
						&&  eObj.getNumb()== getNumb() ;
		}
		return false;
	}
	
}
