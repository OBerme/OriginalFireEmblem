package turner.md.enums;

public enum TurnerEnumConstant {
	SPEED_DIVIDER(1),
	MOVE_COST(1),
	ATACK_COST(1);

    private final int option;

    TurnerEnumConstant( int option) {
        this.option = option;
    }
    
    
    
    public int getCost() {
    	return option;
    }
    

    public static int getNumTurns(int speed) {
    	return speed / SPEED_DIVIDER.getCost();
    }
}
