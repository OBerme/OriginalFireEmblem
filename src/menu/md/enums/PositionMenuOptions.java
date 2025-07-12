package menu.md.enums;

public enum PositionMenuOptions {
	SHPO("Show positions", 20);
	

    private final String message;
    private final int option;

    PositionMenuOptions(String message, int option) {
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
