package menu.md.enums;

public enum AttackMenuOptionsPersona {
	PHY("Physical attack",50),
	GUN("Gun attack", 51);
	
	private final String message;
	private final int option;

	private AttackMenuOptionsPersona(String message, int option) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.option = option;
	}
    @Override
    public String toString() {
        return message + "," + option;
    }
	public String getMessage() {
		return message;
	}

	public int getOption() {
		return option;
	}

}
