package mapa.ln;


import java.util.ArrayList;

import entes.md.Ente;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;

public class LNMapaMatrix extends LNMapa<Integer, Integer> implements ILNMapaMatrix{	
	public LNMapaMatrix(MapaMatrix mapaVector) {
		super();
		this.mapa = mapaVector;
		
	}
	

	@Override
	public String getMapaDesing() {
		// TODO Auto-generated method stub
		return this.mapa.toString();
	}

	@Override
	public void setPosicion(Integer x, Integer y, Posicion<Integer, Integer> posicion) {
		this.mapa.setPosicion(x, y, posicion);
	}


	@Override
	public String toStringNumberPositions() {
		return this.mapa.toStringNumberPositions();
	}

}
