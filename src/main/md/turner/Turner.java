package main.md.turner;

import java.util.List;

public class Turner {
	
	private List<Turnable> turnables;
	private boolean contin;
	private int turn;
	
	public Turner() {
		super();
		this.contin = true;
		this.turn = 0;		
	}

	public List<Turnable> getTurnables() {
		return turnables;
	}

	public void setTurnables(List<Turnable> turnables) {
		this.turnables = turnables;
	}

	public void onTurnPass() {
		turn++;
	}

	public boolean isContin() {
		return contin;
	}

	public void setContin(boolean contin) {
		this.contin = contin;
	}
}
