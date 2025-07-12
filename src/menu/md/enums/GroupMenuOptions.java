package menu.md.enums;

public enum GroupMenuOptions {
	SHEN("Show number group to choose entes", 30),
	WDG("Withdraw the game", 31);

    private final String message;
    private final int option;

    GroupMenuOptions(String message, int option) {
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

