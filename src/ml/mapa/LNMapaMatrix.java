package ml.mapa;

import md.ente.Ente;
import md.mapa.MapaMatrix;
import md.mapa.Posicion;

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
	public void moverEnte(Ente ente, Posicion<Integer, Integer> posi) {
		if(mapa.isEmptyPosicion(posi)) {
			posi.setEnte(ente);
			mapa.setPosicion(posi);
		}
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

}
