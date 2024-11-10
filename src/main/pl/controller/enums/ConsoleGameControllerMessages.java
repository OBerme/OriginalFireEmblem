package main.pl.controller.enums;

import main.md.controller.scanner.enums.DataScannerOptions;

public enum ConsoleGameControllerMessages {
	NOT_AN_OPTION("It's not an option"),
	EXIT("EXIT"),
	
	LOOP_MESSAGE("Give me an option"),
	WELCOME_MESSAGE("Wellcome to FireRules game" 
			+ "\nLets get started"),
	BYE_MESSAGE("Bye for now"),
	
	
	CONFIRM_EXIT("Do you really want to exit? ("  + DataScannerOptions.YES_CONFIRMS.toString() 
			+"/"+ DataScannerOptions.NO_CONFIRMS.toString() + ")\n");

    private final String message;

    ConsoleGameControllerMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
    
    public String getMessage() {
    	return message;
    }
    
}
