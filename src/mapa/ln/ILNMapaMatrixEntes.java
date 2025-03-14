package mapa.ln;

import entes.md.Ente;
import entes.md.IEnte;
import mapa.md.IPosition;
import mapa.md.Posicion;

public interface ILNMapaMatrixEntes extends ILNMapaMatrix{
	public boolean isEnteInMap(IEnte ente);
	
	public IEnte getEnte(int number);
	

	/**
	 * Pre: Ente no tiene que ser null, 
	 * 	posicion tiene que ser una posicion valida del mapa
	 * Post: it will put the ente if its not on the map and if its on the map it will be change
	 * 	 his position to the other one 
	 */
	boolean moverEnte(IEnte ente, Integer x, Integer y);
	
	void addEnte(IEnte ente, Posicion<Integer, Integer> posi);
	boolean removeEnte(IEnte ente);
	
	//Pre: the ente should be not null
	//Post: it will return the position of the ente, null if the ente is not in the map
	IPosition<Integer, Integer> getPositionEnte(IEnte ente);
	
	/**
	 * Pre: posicion tiene que ser una posicion valida del mapa
	 * Post: posi.getEnte() == null
	 */
	void removeEnteFromPosition(Posicion<Integer, Integer> posi);
	
	//Pre: ---
	//Post: it will show all the entes in the map with his number
	String getEnteDesingNumber();
}
