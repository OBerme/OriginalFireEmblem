package scanner.ln;

import mapa.md.Posicion;
import scanner.md.BasicScanner;

public class LNOwnScanner implements ILNOwnScanner  {
    private BasicScanner ownScanner;

    // Constructor
    public LNOwnScanner(BasicScanner ownScanner) {
        this.ownScanner = ownScanner;
    }


}
