package main.md.turner;

import java.util.List;

public class Turner {
	
	private List<Turnable> turnables;
	private boolean contin;
	private int turn;
	
	public Turner(List<Turnable> turnables, IGameEvent gameEvent) {
		super();
		this.turnables = turnables;
		this.contin = true;
		this.turn = 0;		
	}

	public List<Turnable> getTurnables() {
		return turnables;
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
