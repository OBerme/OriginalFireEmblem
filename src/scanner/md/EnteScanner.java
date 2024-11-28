package scanner.md;

import java.util.Scanner;

import entes.md.Ente;
import mapa.ln.IEnteCollection;
import mapa.md.Posicion;
import scanner.ln.ILNDataScanner;

public class EnteScanner extends OwnScanner {
	private ILNDataScanner dataScanner;
	private IEnteCollection enteCollection;
	public EnteScanner(Scanner scn, ILNDataScanner dataScanner, IEnteCollection enteCollection) {
		super(scn);
		this.dataScanner = dataScanner;
		this.enteCollection = enteCollection;
		// TODO Auto-generated constructor stub
	}

	// Método para obtener un ente
    public Ente getEnte() {
    	System.out.println("Give the number of the ente");
    	int number = dataScanner.getInteger();
    	
        // Sin implementación
        return enteCollection.getEnte(number);
    }
}
