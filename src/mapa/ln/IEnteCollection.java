package mapa.ln;

import entes.md.Ente;

public interface IEnteCollection {
	//Pre: ------ 
	//Post: it will return null if the ente dosen't exists, or the ente with that number 
	Ente getEnte(int number);
}
