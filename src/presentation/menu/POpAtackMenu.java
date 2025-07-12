package presentation.menu;

import acciones.md.ataque.IAtack;
import presentation.GAtack.IPAtackController;
import presentation.GAtack.IPGraphicAtack;
import presentation.main.IPEnteController;
import presentation.main.controller.IPController;

public class POpAtackMenu extends POption {
	private IAtack atack;
	private IPAtackController atacContro;
	
	public POpAtackMenu( IPAtackController atacContro,  IAtack atack) {
		super(atack.getName());
		this.atack = atack;
		this.atacContro = atacContro;
	}

	@Override
	public void doAction() {
		atacContro.showAtack(atack);
	}

}
