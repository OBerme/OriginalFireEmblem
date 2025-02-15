package presentation.menu;

import entes.md.Ente;
import presentation.main.IPEnteController;
import presentation.main.PController;

public class POpMoveEnte extends POption{
	private Ente ente;
	public POpMoveEnte(IPEnteController pcontro, Ente ente) {
		super("Move", pcontro);
		this.ente = ente;
	}

	@Override
	public void doAction() {
		((IPEnteController)pcontro).moveEnte(ente);
	}
	
}
