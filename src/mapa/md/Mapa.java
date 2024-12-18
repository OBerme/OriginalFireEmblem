package mapa.md;

import entes.IEnteEvents;
import entes.md.Ente;
import mapa.ln.IEnteCollection;


public abstract class Mapa<X, Y> {
	protected Posicion<X,Y>[] posiciones;
	
	public int getLength() {
		return posiciones.length;
	}
	

	public Posicion<X,Y>[] getPosiciones() {
		return posiciones;
	}
	
	public abstract Posicion<X,Y> getPosicion(X x, Y y) ;
	//Pre: La posicion tiene que ser valida en el mapa, tiene que estar dentro de los rangos
	//Post: Se cambiara la posicion exacta del mapa
	//			,en un inicio las posiciones son nulas pero con este metodo las vamos cargando en el mapa
	public abstract void setPosicion(Posicion<X, Y> posicion) ;
	public abstract boolean isEmptyPosicion(Posicion<X, Y> posicion) ;
	public abstract Posicion<X, Y> getEntePosition(Ente ente);


	public abstract String toStringWithNumber() ;

	public abstract void setPosicion(Integer x, Integer y, Posicion<Integer, Integer> posicion);


	public abstract String toStringNumberPositions() ;

}
