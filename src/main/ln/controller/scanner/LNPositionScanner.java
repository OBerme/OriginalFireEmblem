package main.ln.controller.scanner;

import main.md.controller.scanner.DataScanner;
import main.md.controller.scanner.PositionScanner;
import main.md.mapa.Posicion;

public class LNPositionScanner extends LNDataScanner implements ILNOwnScanner{
    private PositionScanner positionScanner;

    // Constructor
    public LNPositionScanner(PositionScanner positionScanner) {
    	super(new DataScanner(positionScanner.getScn()));
        this.positionScanner = positionScanner;
    }

    // Método para obtener una posición
    public Posicion<Integer, Integer> getPosition() {
        // Sin implementación
    	
    	System.out.print("\nX:");
    	int x = this.dataScanner.getInteger();
    	
    	System.out.print("\nY:");
    	int y = this.dataScanner.getInteger();
    	
    	return new Posicion<Integer, Integer>(x, y);

    }
}

