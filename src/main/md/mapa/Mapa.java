package main.md.mapa;

import main.ln.mapa.IEnteCollection;
import main.md.ente.Ente;
import main.md.ente.IEnteEvents;


public abstract class Mapa<X, Y> implements IEnteEvents{
	protected Posicion<X,Y>[] posiciones;
	
	public int getLength() {
		return posiciones.length;
	}
	

	public Posicion<X,Y>[] getPosiciones() {
		return posiciones;
	}
	
	public abstract Posicion<X,Y> getPosicion(X x, Y y) ;
	
	public abstract void setPosicion(Posicion<X, Y> posicion) ;
	public abstract boolean isEmptyPosicion(Posicion<X, Y> posicion) ;
	public abstract Posicion<X, Y> getEntePosition(Ente ente);


	public abstract String toStringWithNumber() ;

	public abstract void setPosicion(Integer x, Integer y, Posicion<Integer, Integer> posicion);


	public abstract String toStringNumberPositions() ;

}
