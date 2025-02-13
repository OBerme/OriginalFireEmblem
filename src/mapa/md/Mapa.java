package mapa.md;

import java.lang.reflect.Array;
import java.util.Arrays;

import entes.IEnteEvents;
import entes.md.Ente;
import mapa.ln.IEnteCollection;


public abstract class Mapa<X, Y> implements IMapa<X, Y>{
	protected IPosition<X,Y>[] posiciones;
	
	public abstract int getWidth() ;
	
	public abstract int getHeight();
	

	public IPosition<X,Y>[] getPosiciones() {
//		return posiciones;
		return Arrays.copyOf(posiciones, posiciones.length) ;
	}
	
	
	//Pre: La posicion tiene que ser valida en el mapa, tiene que estar dentro de los rangos
	//Post: Se cambiara la posicion exacta del mapa
	//			,en un inicio las posiciones son nulas pero con este metodo las vamos cargando en el mapa
	public abstract void setPosicion(IPosition<X, Y> posi) ;
	public abstract boolean isEmptyPosicion(IPosition<X, Y> posicion) ;
	public abstract IPosition<Integer, Integer> getEntePosition(Ente ente);


	public abstract String toStringWithNumber() ;

	public abstract void setPosicion(X x, Y y, IPosition<X, Y> posicion);


	public abstract String toStringNumberPositions() ;
	
	public abstract boolean hasPosition(X x, Y y) ;
	




	

}
