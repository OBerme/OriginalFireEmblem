package mapa.md;

import entes.md.Ente;
import group.md.Group;
import group.md.Groupable;
import turner.md.Actionable;

public class Posicion<X,Y> {
	private X x;
	private Y y;
	private Ente ente;
	public static final String EMPTY_STR = " ";
	public static final String WITHOUT_ACTIONS = "X";
	

	public Posicion(X x, Y y) {
		this(x, y, null);
	}
	
	public Posicion(X x, Y y, Ente ente) {
		super();
		this.x = x;
		this.y = y;
		this.ente = ente;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Posicion) {
			Posicion<X, Y> objPosi = (Posicion<X, Y>)obj; 
			return objPosi.getX().equals(getX()) && objPosi.getY().equals(getY());
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getX()+"," + getY();
	}
	
	public X getX() {
		return x;
	}
	public void setX(X x) {
		this.x = x;
	}
	public Y getY() {
		return y;
	}
	public void setY(Y y) {
		this.y = y;
	}
	public Ente getEnte() {
		return ente;
	}
	public void setEnte(Ente ente) {
		this.ente = ente;
	}
	
	public boolean hasEnte() {
		return ente != null;
	}
	
	public String getRepresentation() {
		if(hasEnte()) {
			return this.ente.getShortName();
		}
			
		return EMPTY_STR;
	}
	
}
