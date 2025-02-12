package presentation.menu;

import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.Ataque;
import entes.Atacable;
import entes.Movable;
import entes.md.Ente;
import presentation.main.IPEnteController;
import presentation.main.PController;
import turner.md.Actionable;

public class PMenuAbstractFactory {
	public static PMenu getDefaultMenuEnte(Ente ente, IPEnteController pContro) {
		List<IPOption> options = new ArrayList<IPOption>();
		if(ente instanceof Actionable) {
			if(ente instanceof Movable) {
				options.add(new POpMoveEnte(pContro));
			}
			if(ente instanceof Atacable) {
				options.add(new POpShowMenu("Atack", pContro,
						getDefaultMenuAtacks(
								((Atacable)ente).getAtacks() )));
			}	
		}
		options.add(new POpSkip(pContro));
	
		return new PMenu(options);
	}
	
	public static PMenu getDefaultMenuCell(IPEnteController pContro) {
		List<IPOption> options = new ArrayList<IPOption>();
		return new PMenu(options);
	}
	
	public static PMenu getDefaultMenuAtacks(List<Ataque> atacks) {
		List<IPOption> options = new ArrayList<IPOption>();
		
		//Check if the option is avaliable with the power of the ente
		return new PMenu(options) ;
	}
}
