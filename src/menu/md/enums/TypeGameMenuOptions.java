package menu.md.enums;

public enum TypeGameMenuOptions {
	GLG("Get local game", 1),
	GWG("Get Web Game", 2);
	

    private final String message;
    private final int option;

    TypeGameMenuOptions(String message, int option) {
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
