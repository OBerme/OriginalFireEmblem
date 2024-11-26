package main.md.controller.menu.enums;

public enum ActionableMenuOptions {
	WTS("Wants to skip", 40),
	DAA("Do all actions", 41);
	

    private final String message;
    private final int option;

    ActionableMenuOptions(String message, int option) {
        this.message = message;
        this.option = option;
    }

    @Override
    public String toString() {
        return message + "," + option;
    }
    
    public String getMessage() {
    	return message;
    }
    
    public int getOption() {
    	return option;
    }

}
