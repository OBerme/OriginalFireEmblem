package mapa.md;

import entes.md.Ente;

public interface IPosition<X, Y> {
	 boolean isEmpty();
	 boolean hasSomething();
	 IPositionable getSomething();
	 
	 
	 
	 X getX();
	 Y getY();
	 void setX(X x);
	 void setY(Y y);
	 
	void setSomething(IPositionable positi);
	String getRepresentation();
	String getRepresentationNumber();
	
}
