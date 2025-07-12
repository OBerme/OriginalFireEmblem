package mapa.ln;

import entes.md.Ente;
import mapa.md.Posicion;

public interface ILNMapaMatrix extends INLMapa<Integer, Integer>{
	public void setPosicion(Integer x, Integer y, Posicion<Integer, Integer> posicion);
	public String getEnteDesingNumber();
	String getErrorMessageInvalidPosition(Integer x, Integer y);
	boolean isEmptyPosition(Integer x, Integer y);
	boolean isValidPosition(Integer x, Integer y);
}
