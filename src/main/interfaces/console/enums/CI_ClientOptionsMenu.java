package main.interfaces.console.enums;

public enum CI_ClientOptionsMenu {
    //MENU OPTIONS
    SE("Send a echo", 0),
    SME("Send more echos", 1),
    EXIT_OPTION_MESSAGE("Exit", 2);

    // ...otros mensajes de error...

    private final String message;
    private final  Integer option;

    CI_ClientOptionsMenu(String message, Integer option) {
        this.message = message;
        this.option = option;
    }

    @Override
    public String toString() {
        return message;
    }

    public Integer getOption() {return this.option;  }
}