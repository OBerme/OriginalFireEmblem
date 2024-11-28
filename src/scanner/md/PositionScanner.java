package scanner.md;

import java.util.Scanner;

import mapa.md.Posicion;
import scanner.ln.ILNDataScanner;

public class PositionScanner extends OwnScanner {
	private ILNDataScanner dataScanner;

    public PositionScanner(Scanner scn, ILNDataScanner dataScanner) {
		super(scn);
		this.dataScanner = dataScanner;
		// TODO Auto-generated constructor stub
	}

	public Posicion<Integer, Integer> getPosition() {
        // Sin implementación
		System.out.print("\nX:");
    	int x = dataScanner.getInteger();
    	System.out.print("\nY:");
    	int y = dataScanner.getInteger();
    	
        // Sin implementación
        return new Posicion<Integer, Integer>(x, y);
    }
}