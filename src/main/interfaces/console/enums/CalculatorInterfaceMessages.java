package main.interfaces.console.enums;

public enum CalculatorInterfaceMessages {

    WELCOME_MESSAGE("WELCOME TO CALCULATOR 1.0 FORM OSCAR BERMEJO DOMINGUEZ" +
            "\nLets start with some operations!"),
    INSERT_NEW_OPERATION_MESSAGE("Insert a new operation to do!"),
    EXIT_MESSAGE_CONFIRMS_MESSAGE("Are you sure you want to exit?"),
    CHOOSE_YES_MESSAGE("Yes/no?"),
    NO_OPTIONS("There is no options"),
    
    
    //Error message
    WRONG_CONFIRMS_FORMAT("You wrote something wrong, please give me a valid option"),
    WRONG_INTEGER_FORMAT("Please give a valid number, you have written wrong"),
    WRONG_DOUBLE_FORMAT("Please give a valid double value, you have written wrong"),
    PLEASE_GIVE_AN_OPTION("Please give an option"),
    VALID_OPTION("Please give me a valid option"),
    EMPTY_OPERATION("You didn't insert nothing"),
    GIVE_ME_NEXT_VARIABLE("Please give the next value of variable"),
    NOT_AN_OPTION("This is not an option"),
    BYE_MESSAGE("Bye and have a nice day!"),
    SOMETHING_WENT_WRONG("Something went wrong");

    private final String message;

    CalculatorInterfaceMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

