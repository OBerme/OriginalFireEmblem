package menu.md.enums;

public enum EnteMenuOptions {
	SHEN("Show number to choose entes", 10),
	MOEN("Move an ente", 11),
	DAEN("Data of an ente", 12),
	ATEN("Attack with an ente", 13);
	

    private final String message;
    private final int option;

    EnteMenuOptions(String message, int option) {
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
