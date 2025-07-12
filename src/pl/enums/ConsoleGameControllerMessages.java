package pl.enums;

import scanner.md.enums.DataScannerOptions;

public enum ConsoleGameControllerMessages {
	NOT_AN_OPTION("It's not an option"),
	EXIT("EXIT"),
	
	LOOP_MESSAGE("Give me an option"),
	TURN_MESSAGE("Its your turn"),
	DONE_ACTIONS("You set all the actions"),
	
	
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
    
    public static String getPlayerTurnMessage(String namePlayer)
    {
    	return TURN_MESSAGE + " " +namePlayer + "!";
    }
}
