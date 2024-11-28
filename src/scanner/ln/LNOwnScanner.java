package scanner.ln;

import mapa.md.Posicion;
import scanner.md.OwnScanner;

public class LNOwnScanner implements ILNOwnScanner  {
    private OwnScanner ownScanner;

    // Constructor
    public LNOwnScanner(OwnScanner ownScanner) {
        this.ownScanner = ownScanner;
    }


}
