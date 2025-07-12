package presentation.menu;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import entes.Atacable;
import entes.Movable;
import entes.md.Ente;
import entes.md.IEnte;
import presentation.GAtack.IPAtackController;
import presentation.graphicOptions.IShowMenus;
import presentation.main.IAbstractFactoryPMenu;
import presentation.main.IPEnteController;
import presentation.main.controller.IPController;
import turner.md.Actionable;

//Singleton class 
public class PMenuAbstractFactory implements IAbstractFactoryPMenu{
	
	
	private static PMenu voidMenu; //Empty menu

	private IPEnteController eContro;
	private IPAtackController aContro;
	private Component invoker;
	private IPController contro;
	private IShowMenus iShowMenu;
	
	public PMenuAbstractFactory(IPEnteController eContro, IPAtackController aContro, JFrame invoker,
			IPController contro, IShowMenus iShowMenu) {
		super();
		this.eContro = eContro;
		this.aContro = aContro;
		this.invoker = invoker;
		this.contro = contro;
		this.iShowMenu = iShowMenu;
		voidMenu = new PMenu(null);
		voidMenu.onFinishedAddedOptions();
	}






	@Override
	public IPMenu<Integer, Integer> createMenuEnte(IEnte ente) {
		PMenuEnte pMEnte= new PMenuEnte(invoker);
	
		if(ente instanceof Actionable) {
			if(ente instanceof Movable) {
				pMEnte.addOption(new POpMoveEnte(eContro, ente, pMEnte));
			}
			if(ente instanceof Atacable) { //TODO improve the way we create
				pMEnte.addOption(new POpShowMenu("Atack", iShowMenu,
						getDefaultMenuAtacks(
								((Atacable)ente).getAtacks() , invoker)));
			}	
		}
		
		pMEnte.addOption(new POpSkip(contro));
		pMEnte.onFinishedAddedOptions();
		
		return pMEnte;
	}
	
	public IPMenu<Integer, Integer> getEmptyMenu() {
		return voidMenu;
	}
	
	public IPMenu<Integer, Integer> getDefaultMenuAtacks(List<IAtack> atacks, 
			Component invoker) {
		PMenu menu = new  PMenu(invoker); 
		
		for(IAtack nAtack : atacks) {
			menu.addOption(new POpAtackMenu(aContro, nAtack));
		}
		
		menu.onFinishedAddedOptions();
		return menu;
		
	}
}
