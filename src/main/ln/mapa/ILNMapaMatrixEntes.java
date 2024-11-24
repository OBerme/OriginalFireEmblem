package main.ln.mapa;

import main.md.ente.Ente;
import main.md.mapa.Posicion;

public interface ILNMapaMatrixEntes extends ILNMapaMatrix{
	public boolean isEnteInMap(Ente ente);
	public String getNumberEntesDesing();
	public Ente getEnte(int number);
	
	boolean moverEnte(Ente ente, Posicion<Integer, Integer> posi);
	
	void addEnte(Ente ente, Posicion<Integer, Integer> posi);
	boolean removeEnte(Ente ente);
	/**
	 * Pre: posicion tiene que ser una posicion valida del mapa
	 * Post: posi.getEnte() == null
	 */
	void removeEnteFromPosition(Posicion<Integer, Integer> posi);
}
