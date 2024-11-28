package scanner.ln;

import mapa.md.Posicion;
import scanner.md.DataScanner;
import scanner.md.OwnScanner;

public class LNDataScanner implements ILNDataScanner  {
    protected DataScanner dataScanner;

    // Constructor
    public LNDataScanner(DataScanner dataScanner) {
        this.dataScanner = dataScanner;
    }

    // Métodos según el diagrama
    public String getLine() {
        // Sin implementación
        return dataScanner.getLine();
    }

    public int getInteger() {
        // Sin implementación
        return dataScanner.getInteger();
    }

    public boolean confirms() {
        // Sin implementación
        return dataScanner.confirms();
    }

    public double getDouble() {
        // Sin implementación
        return dataScanner.getDouble();
    }

}
