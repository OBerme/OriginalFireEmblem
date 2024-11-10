package main.ln.controller.scanner;

import main.md.controller.scanner.OwnScanner;
import main.md.mapa.Posicion;

public class LNOwnScanner implements ILNOwnScanner  {
    private OwnScanner ownScanner;

    // Constructor
    public LNOwnScanner(OwnScanner ownScanner) {
        this.ownScanner = ownScanner;
    }


}
