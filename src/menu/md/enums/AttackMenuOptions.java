package menu.md.enums;

public enum AttackMenuOptions {
	PHY("Physical attack",50),
	MAG("Magical attack", 51);
	
	private final String message;
	private final int option;

	AttackMenuOptions(String message, int option) {
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
