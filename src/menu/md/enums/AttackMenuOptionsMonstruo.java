package menu.md.enums;

public enum AttackMenuOptionsMonstruo {
	PHY("Physical attack",50),
	MAG("Magical attack", 51);
	
	private final String message;
	private final int option;

	AttackMenuOptionsMonstruo(String message, int option) {
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
