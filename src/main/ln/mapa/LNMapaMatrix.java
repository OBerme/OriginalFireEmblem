package main.ln.mapa;


import java.util.ArrayList;

import main.md.ente.Ente;
import main.md.mapa.MapaMatrix;
import main.md.mapa.Posicion;

public class LNMapaMatrix extends LNMapa<Integer, Integer>{

	
	
	
	
	
	public LNMapaMatrix(MapaMatrix mapaVector) {
		super();
		this.mapa = mapaVector;
		
	}

	/**
	 * Pre: Ente no tiene que ser null, 
	 * 	posicion tiene que ser una posicion valida del mapa
	 */
	@Override
	public boolean moverEnte(Ente ente, Posicion<Integer, Integer> posi) {
		if(mapa.isEmptyPosicion(posi)) {
			setEntePosition(ente, posi);
			return true;
		}
		return false;
	}

	protected void setEntePosition(Ente ente, Posicion<Integer, Integer> posi) {
		posi.setEnte(ente);
		mapa.setPosicion(posi);
	}
	
	/**
	 * Pre: posicion tiene que ser una posicion valida del mapa
	 * Post: posi.getEnte() == null
	 */
	@Override
	public void removeEnteFromPosition(Posicion<Integer, Integer> posi) {
		posi.setEnte(null);	
	}
	
	

	@Override
	public boolean eleminarEnte(Ente ente) {
		Posicion<Integer,Integer> fPosition = null;
		for(Posicion<Integer, Integer> nPosi : mapa.getPosiciones()) {
			if(nPosi.getEnte().equals(ente)) {
				fPosition = nPosi;
				break;
			}
		}
		if(fPosition == null)
			return false;
		
		//Change the value of ente
		
		return false;
	}

	@Override
	public String getMapaDesing() {
		// TODO Auto-generated method stub
		return this.mapa.toString();
	}

}
