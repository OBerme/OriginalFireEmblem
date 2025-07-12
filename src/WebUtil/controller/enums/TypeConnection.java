package WebUtil.controller.enums;

public enum TypeConnection {
	//MENU OPTIONS
    GLU("Get list of users", "GET"),
    WOC("Wait for other client", "PUSH"),
	WD("Wants to disconnect", "REMOVE");

    // ...otros mensajes de error...

    private final String message, formatMessa;

    TypeConnection(String message, String formatMessa) {
        this.message = message;
        this.formatMessa = formatMessa;
    }

    @Override
    public String toString() {
        return message + "," + formatMessa;
    }
    
    public String getMessageConnection() {
    	return formatMessa;
    }

}
