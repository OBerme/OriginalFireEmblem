package main.ln.controller.scanner;

import main.md.controller.scanner.DataScanner;
import main.md.controller.scanner.EnteScanner;
import main.md.ente.Ente;

public class LNEnteScanner extends LNDataScanner implements ILNEnteScanner{
	 private EnteScanner enteScanner;

	    // Constructor
	    public LNEnteScanner(EnteScanner enteScanner) {
	    	super(new DataScanner(enteScanner.getScn()));
	        this.enteScanner = enteScanner;
	    }


	    public Ente getEnte() {
	        // Sin implementación
	    	System.out.println("Give me the number of the ente");
	        return null;
	    }
}
