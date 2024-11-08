package ML.mapa;

import MD.Ente.Ente;
import MD.Mapa.MapaMatrix;
import MD.Mapa.Posicion;

public class LNMapaMatrix extends LNMapa<Integer, Integer>{

	
	private MapaMatrix mapaVector;
	
	
	
	public LNMapaMatrix(MapaMatrix mapaVector) {
		super();
		this.mapaVector = mapaVector;
	}

	/**
	 * Pre: Ente no tiene que ser null, 
	 * 	posicion tiene que ser una posicion valida del mapa
	 */
	@Override
	public void moverEnte(Ente ente, Posicion<Integer, Integer> posi) {
		
		if(mapaVector.isEmptyPosicion(posi)) {
			posi.setEnte(ente);
			mapaVector.setPosicion(posi);
		}
		
		
	}
	
	

	@Override
	public boolean eleminarEnte(Ente ente) {
		// TODO Auto-generated method stub
		return false;
	}

}
