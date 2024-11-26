package main.md.turner.constants;

public enum TurnerEnumConstant {
	SPEED_DIVIDER(2);

    private final int option;

    TurnerEnumConstant( int option) {
        this.option = option;
    }
    
    public int getSpeedConstant() {
    	return option;
    }
    

    public static int getNumTurns(int speed) {
    	return speed / SPEED_DIVIDER.getSpeedConstant();
    }
}
