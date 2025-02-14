package presentation.menu;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.Ataque;
import entes.Atacable;
import entes.Movable;
import entes.md.Ente;
import presentation.main.IPEnteController;
import presentation.main.PController;
import turner.md.Actionable;

//Singleton class 
public class PMenuAbstractFactory {
	
	
	private static PMenu voidMenu; //Empty menu
	

	private PMenuAbstractFactory(){
		List<IPOption> options = new ArrayList<IPOption>();
		voidMenu = new PMenu(options, null);
	}
	
	public static PMenu getDefaultMenuEnte(Ente ente, IPEnteController pContro, Component invoker) {
		List<IPOption> options = new ArrayList<IPOption>();
		if(ente instanceof Actionable) {
			if(ente instanceof Movable) {
				options.add(new POpMoveEnte(pContro));
			}
			if(ente instanceof Atacable) {
				options.add(new POpShowMenu("Atack", pContro,
						getDefaultMenuAtacks(
								((Atacable)ente).getAtacks() , invoker)));
			}	
		}
		options.add(new POpSkip(pContro));
	
		return new PMenu(options,invoker);
	}
	
	public static PMenu getEmptyMenu() {
		if(voidMenu == null) new PMenuAbstractFactory();
		return voidMenu;
	}
	
	public static PMenu getDefaultMenuAtacks(List<Ataque> atacks, Component invoker) {
		List<IPOption> options = new ArrayList<IPOption>();
		
		//Check if the option is avaliable with the power of the ente
		return new PMenu(options,invoker) ;
	}
}
