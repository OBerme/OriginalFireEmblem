package WebServer.interfaces.console.enums;

import WebServer.controller.enums.TypeConnection;

public enum CI_ClientConnect_OptionsMenu {
    //MENU OPTIONS
    WM("", 1),
    EXIT_OPTION_MESSAGE(TypeConnection.WD.getMessageConnection(), 2);

    // ...otros mensajes de error...

    private final String message;
    private final  Integer option;

    CI_ClientConnect_OptionsMenu(String message, Integer option) {
        this.message = message;
        this.option = option;
    }

    @Override
    public String toString() {
        return message;
    }

    public Integer getOption() {return this.option;  }

	public String getMessage() {
		return message;
	}
    

}
