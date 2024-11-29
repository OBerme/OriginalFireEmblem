package WebUtil.interfaces.console.enums;

public enum ConsoleInterfaceStaticOptions {
    YES_CONFIRMS("yes"),
    NO_CONFIRMS("no");



    private final String message;

    ConsoleInterfaceStaticOptions(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

