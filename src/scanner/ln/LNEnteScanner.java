package scanner.ln;

import entes.md.Ente;
import scanner.md.DataScanner;
import scanner.md.EnteScanner;

public class LNEnteScanner extends LNDataScanner implements ILNEnteScanner{
	 private EnteScanner enteScanner;

	    // Constructor
	    public LNEnteScanner(EnteScanner enteScanner) {
	    	super(new DataScanner(enteScanner.getScn()));
	        this.enteScanner = enteScanner;
	    }


	    public Ente getEnte() {
	        // Sin implementación
	    	
	        return enteScanner.getEnte();
	    }
}
