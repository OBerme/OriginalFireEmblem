package main.ln.mapa;


import java.util.HashMap;

import main.md.ente.Ente;
import main.md.mapa.MapaMatrix;
import main.md.mapa.Posicion;

public class LNMapaMatrixEntes extends LNMapaMatrix 
	implements ILNMapaMatrixEntes, IEnteCollection, IEnteNumberShowable{
	
	private HashMap<Integer, Ente> entes;
	public LNMapaMatrixEntes(MapaMatrix mapaVector) {
		super(mapaVector);
		// TODO Auto-generated constructor stub
		this.entes = new HashMap<Integer, Ente>();
	}

	/**
	 * Pre: Ente no tiene que ser null, 
	 * 	posicion tiene que ser una posicion valida del mapa
	 */
	@Override
	public boolean moverEnte(Ente ente, Posicion<Integer, Integer> posi) {
		if(mapa.isEmptyPosicion(posi)) {
			if(isEnteInMap(ente)) {
				Posicion<Integer, Integer> lPosition = this.mapa.getEntePosition(ente);
				lPosition.setEnte(null);
			}
			else 
				appendEnte(ente);
			
			super.setEntePosition(ente, posi);
				
			
			return true;
		}
		return false;
	}
	
	
	private void appendEnte(Ente ente) {
		ente.setNumb(entes.size()+1);
		entes.put(ente.getNumb(), ente);
	}
	
	public boolean isEnteInMap(Ente ente) {
		if(entes.size() == 0) 
			return false;
		
		for(Ente nEnte : entes.values()) {
			if(nEnte.equals(ente)) 
				return true;		
		}
		
		return false;
	}


	@Override
	public Ente getEnte(int number) {
		if(entes.containsKey(number)) {
			return entes.get(number);
		}
		return null;
	}



	@Override
	public String getNumberEntesDesing() {
		return mapa.toStringWithNumber();
		
	}

	@Override
	public String getMapaDesing() {
		// TODO Auto-generated method stub
		return super.getMapaDesing();
	}
	
	public void setPosicion(Integer x, Integer y, Posicion<Integer, Integer> posicion) {
		this.mapa.setPosicion(x, y, posicion);
	}
	
	public String toStringNumberPositions() {
		return this.mapa.toStringNumberPositions();
	}
	
}
