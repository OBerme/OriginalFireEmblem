package main.ln.mapa;

import main.md.ente.Ente;

public interface ILNMapaMatrixEntes extends ILNMapaMatrix{
	public boolean isEnteInMap(Ente ente);
	public String getNumberEntesDesing();
	public Ente getEnte(int number);
}
