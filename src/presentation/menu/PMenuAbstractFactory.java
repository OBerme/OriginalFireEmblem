package presentation.menu;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import entes.Atacable;
import entes.Movable;
import entes.md.Ente;
import entes.md.IEnte;
import presentation.main.IAbstractFactoryPMenu;
import presentation.main.IPController;
import presentation.main.IPEnteController;
import presentation.main.PController;
import turner.md.Actionable;

//Singleton class 
public class PMenuAbstractFactory implements IAbstractFactoryPMenu{
	
	
	private static PMenu voidMenu; //Empty menu

	private IPEnteController pContro;
	private Component invoker;
	private IPController contro;

	public PMenuAbstractFactory(IPEnteController pContro, Component invoker, IPController contro) {
		super();
		this.pContro = pContro;
		this.invoker = invoker;
		this.contro = contro;
		voidMenu = new PMenu(null);
		voidMenu.onFinishedAddedOptions();
	}

	
	@Override
	public IPMenu<Integer, Integer> createMenuEnte(IEnte ente) {
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
	
	public IPMenu<Integer, Integer> getEmptyMenu() {
		return voidMenu;
	}
	
	public IPMenu<Integer, Integer> getDefaultMenuAtacks(List<IAtack> atacks, 
			Component invoker,IPController contro) {
		PMenu menu = new  PMenu(invoker); 
		
		for(IAtack nAtack : atacks) {
			menu.addOption(new POpAtackMenu(contro, nAtack));
		}
		
		menu.onFinishedAddedOptions();
		return menu;
		
	}
}
