package presentation.menu;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import entes.Atacable;
import entes.Movable;
import entes.md.Ente;
import presentation.main.IPController;
import presentation.main.IPEnteController;
import presentation.main.PController;
import turner.md.Actionable;

//Singleton class 
public class PMenuAbstractFactory {
	
	
	private static PMenu voidMenu; //Empty menu
	

	private PMenuAbstractFactory(){
		voidMenu = new PMenu(null);
		voidMenu.onFinishedAddedOptions();
	}
	
	public static IPMenu<Integer, Integer> getDefaultMenuEnte(Ente ente, 
			IPEnteController pContro, Component invoker, IPController contro ) {
		PMenuEnte pMEnte= new PMenuEnte(invoker);
	
		if(ente instanceof Actionable) {
			if(ente instanceof Movable) {
				pMEnte.addOption(new POpMoveEnte(pContro, ente, pMEnte));
			}
			if(ente instanceof Atacable) {
				pMEnte.addOption(new POpShowMenu("Atack", pContro,
						getDefaultMenuAtacks(
								((Atacable)ente).getAtacks() , invoker, contro)));
			}	
		}
		
		pMEnte.addOption(new POpSkip(pContro));
		pMEnte.onFinishedAddedOptions();
		
		return pMEnte;
	}
	
	public static IPMenu<Integer, Integer> getEmptyMenu() {
		if(voidMenu == null) new PMenuAbstractFactory();
		return voidMenu;
	}
	
	public static IPMenu<Integer, Integer> getDefaultMenuAtacks(List<IAtack> atacks, 
			Component invoker,IPController contro) {
		PMenu menu = new  PMenu(invoker); 
		
		for(IAtack nAtack : atacks) {
			menu.addOption(new POpAtackMenu(contro, nAtack));
		}
		
		menu.onFinishedAddedOptions();
		return menu;
		
	}
}
