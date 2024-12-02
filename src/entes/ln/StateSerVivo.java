package entes.ln;

public enum StateSerVivo {
	ENVENENADO("ENVENENADO"),
	QUEMADO("QUEMADO"),
	CONGELADO("CONGLEADO"),
	NORMAL("NORMAL");
	
	private final String message;

	StateSerVivo(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
    
    public String getState() {
    	return message;
    }
}
