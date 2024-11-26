package main.ln.turner;

import main.md.turner.IGameEvent;
import main.md.turner.ITurnerEvents;
import main.md.turner.Turnable;
import main.md.turner.Turner;

public class LNTurner implements ITurnerEvents{
	private IGameEvent gameEvent;
	private Turner turner;
	
	public LNTurner(Turner turner) {
		super();
		this.turner = turner;
	}

	public void start() {
		run();
	}
	
	private void run() {
		while(turner.isContin()) {
			doTurn();
		}
		gameEvent.onGameEnds();
	}
	
	private void doTurn() {
		for(Turnable nTurnable : turner.getTurnables()) {
			nTurnable.doTurn();
		}
		turner.onTurnPass();
	}

	@Override
	public void onGiveUp() {
		turner.setContin(false);
	}
}
