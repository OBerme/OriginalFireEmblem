package scanner.ln;

import mapa.md.Posicion;
import scanner.md.DataScanner;
import scanner.md.PositionScanner;

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

