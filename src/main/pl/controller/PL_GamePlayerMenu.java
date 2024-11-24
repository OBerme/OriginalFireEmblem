package main.pl.controller;

import main.ln.controller.menu.ILNBasicMenu;
import main.ln.controller.menu.ILNEnteMenu;
import main.ln.controller.menu.ILNGroupMenu;
import main.ln.controller.menu.ILNMenu;
import main.ln.controller.menu.ILNPositionMenu;
import main.ln.controller.menu.LNBasicMenu;
import main.ln.controller.menu.LNEnteMenu;
import main.ln.controller.menu.LNPositionMenu;
import main.md.controller.menu.BasicMenu;
import main.md.controller.menu.EnteMenu;
import main.md.controller.menu.PositionMenu;

public class PL_GamePlayerMenu {
	private ILNMenu[] menus;
	private ILNBasicMenu basicMenu;
	private ILNPositionMenu positionMenu;
	private ILNEnteMenu enteMenu;
	private ILNGroupMenu groupMenu;
	
	private String loopMessage;
	
	public PL_GamePlayerMenu(String loopMessage, ILNGroupMenu groupMenu) {
		
		BasicMenu bM = new BasicMenu();
		this.basicMenu = new LNBasicMenu(bM);

		PositionMenu pM = new PositionMenu();
		this.positionMenu = new LNPositionMenu(pM);
		
		EnteMenu eM = new EnteMenu();
		this.enteMenu = new LNEnteMenu(eM);
		
		this.groupMenu = groupMenu;
		
		menus = new ILNMenu[]{
			enteMenu,
			positionMenu,
			basicMenu,
			groupMenu
		};
		
		this.loopMessage = loopMessage;
		
	}
	
	public void showMenu() {
		System.out.println(loopMessage);
		for(ILNMenu nILMenu : menus) {
			nILMenu.showMenuOptions();
		}
	}
	
	public boolean isAnOption(int option) {
		for(ILNMenu nILMenu : menus) {
			Integer[] nOptions = nILMenu.getMenuOptions();
			for(Integer nOption : nOptions) {
				if(nOption == option)
					return true;
			}
		}
		return false;
		 
	}
	
	
}
