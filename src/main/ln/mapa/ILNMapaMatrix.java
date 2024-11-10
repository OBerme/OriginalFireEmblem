package main.ln.mapa;

import main.md.ente.Ente;
import main.md.mapa.Posicion;

public interface ILNMapaMatrix extends INLMapa<Integer, Integer>{
	public void setPosicion(Integer x, Integer y, Posicion<Integer, Integer> posicion);
	public String toStringNumberPositions();
}