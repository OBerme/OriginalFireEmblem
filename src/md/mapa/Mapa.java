package md.mapa;

import md.ente.Ente;
import md.ente.IEnteEvents;

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
}
