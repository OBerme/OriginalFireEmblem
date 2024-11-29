package scanner.md.enums;

public enum TypeGameScannerOptions {
	 

	INTRO_MESSAGE("HI THERE! "
			+ "\n Your going to start a new game!"
			+ "\n But firt, give me which kind of game do you want to start?");
    private final String message;

    TypeGameScannerOptions(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
