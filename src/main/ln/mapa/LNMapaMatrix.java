package main.ln.mapa;


import java.util.ArrayList;

import main.md.ente.Ente;
import main.md.mapa.MapaMatrix;
import main.md.mapa.Posicion;

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
