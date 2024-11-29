package WebServer.interfaces.console.enums;

public enum CI_Client {
	
	//ERROR MESSAGES
    E_GVO("Please give me a valid option");



    private final String message;

    CI_Client(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

