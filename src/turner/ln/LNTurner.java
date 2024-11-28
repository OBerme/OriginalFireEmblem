package turner.ln;

import turner.md.IGameEvent;
import turner.md.ITurnerEvents;
import turner.md.Turnable;
import turner.md.Turner;

public class LNTurner implements ITurnerEvents{
	private IGameEvent gameEvent;
	private Turner turner;
	
	public LNTurner(Turner turner, IGameEvent gameEvent) {
		super();
		this.turner = turner;
		this.gameEvent = gameEvent;
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
			if(turner.isContin())
				nTurnable.doTurn();
		}
		turner.onTurnPass();
	}

	@Override
	public void onGiveUp() {
		turner.setContin(false);
	}
}
