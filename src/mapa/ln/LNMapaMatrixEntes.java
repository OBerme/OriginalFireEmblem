package mapa.ln;


import java.util.HashMap;

import entes.IEnteEvents;
import entes.md.Ente;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;

public class LNMapaMatrixEntes extends LNMapaMatrix 
	implements ILNMapaMatrixEntes, IEnteCollection, IEnteNumberShowable, IEnteEvents{
	
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
			
			setEntePosition(ente, posi);
				
			
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
	
	

	@Override
	public void onEnteDies(Ente ente) {
		if(isEnteInMap(ente)) {
			removeEnte(ente);
		}
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
	public boolean removeEnte(Ente ente) {
		Posicion<Integer,Integer> fPosition = null;
		for(Posicion<Integer, Integer> nPosi : mapa.getPosiciones()) {
			if(nPosi != null) {
				if(nPosi.getEnte() != null) {
					if(nPosi.getEnte().equals(ente)) {
						fPosition = nPosi;
						break;
					}
				}
			}
		}
		if(fPosition == null)
			return false;
		
		//Change the value of ente
		fPosition.setEnte(null);
		this.entes.remove(ente.getNumb());
		
		return true;
	}

	@Override
	public void addEnte(Ente ente, Posicion<Integer, Integer> posi) {
		this.entes.put(ente.getNumb(), ente);
		setEntePosition(ente, posi);
		
	}

	
	
}
