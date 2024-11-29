package WebServer.interfaces.console.enums;

public enum CI_ClientDisco_OptionsMenu {
    //MENU OPTIONS
    RLU("Recibir la lista de usuarios disponibles para chatear", 1),
    CTU("Conectarme a un usuario", 2),
    WFC("Quedarme a la espera de recibir conexiones", 3),
    
    EXIT_OPTION_MESSAGE("Salir", 4);

    // ...otros mensajes de error...

    private final String message;
    private final  Integer option;

    CI_ClientDisco_OptionsMenu(String message, Integer option) {
        this.message = message;
        this.option = option;
    }

    @Override
    public String toString() {
        return message;
    }

    public Integer getOption() {return this.option;  }
}
