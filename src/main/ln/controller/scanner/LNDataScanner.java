package main.ln.controller.scanner;

import main.md.controller.scanner.DataScanner;
import main.md.controller.scanner.OwnScanner;
import main.md.mapa.Posicion;

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
