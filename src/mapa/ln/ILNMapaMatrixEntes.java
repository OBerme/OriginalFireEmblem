package mapa.ln;

import entes.md.Ente;
import mapa.md.IPosition;
import mapa.md.Posicion;

public interface ILNMapaMatrixEntes extends ILNMapaMatrix{
	public boolean isEnteInMap(Ente ente);
	
	public Ente getEnte(int number);
	
	boolean moverEnte(Ente ente, Integer x, Integer y);
	
	void addEnte(Ente ente, Posicion<Integer, Integer> posi);
	boolean removeEnte(Ente ente);
	
	/**
	 * Pre: posicion tiene que ser una posicion valida del mapa
	 * Post: posi.getEnte() == null
	 */
	void removeEnteFromPosition(Posicion<Integer, Integer> posi);
	
	//Pre: ---
	//Post: it will show all the entes in the map with his number
	String getEnteDesingNumber();
}
