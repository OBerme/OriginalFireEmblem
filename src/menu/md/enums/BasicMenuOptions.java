package menu.md.enums;

public enum BasicMenuOptions {
	EXIT("EXIT", 1);

    private final String message;
    private final int option;

    BasicMenuOptions(String message, int option) {
        this.message = message;
        this.option = option;
    }

    @Override
    public String toString() {
        return message + ":" + option;
    }
    
    public String getMessage() {
    	return message;
    }
    
    public int getOption() {
    	return option;
    }

}
