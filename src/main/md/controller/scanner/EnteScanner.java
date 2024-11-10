package main.md.controller.scanner;

import java.util.Scanner;

import main.ln.controller.scanner.ILNDataScanner;
import main.ln.mapa.IEnteCollection;
import main.md.ente.Ente;
import main.md.mapa.Posicion;

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

