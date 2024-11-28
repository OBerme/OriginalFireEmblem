package scanner.md.enums;

public enum DataScannerOptions {
	 YES_CONFIRMS("yes"),
	 NO_CONFIRMS("no"),
	
	
	WRONG_CONFIRMS_FORMAT("The format of the comand wasn't correct, please try again"),
	WRONG_DOUBLE_FORMAT("The format of the double inserted wasn't correct, please try again"),
	WRONG_LINE_FORMAT("Please give me a valid string not a number"),
	WRONG_INTEGER_FORMAT("The format of the integer inserted wasn't correct, please try again");
    private final String message;

    DataScannerOptions(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
