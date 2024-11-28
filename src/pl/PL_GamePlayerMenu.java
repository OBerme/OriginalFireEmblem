package pl;

import menu.ln.ILNActionableMenu;
import menu.ln.ILNAttackMenu;
import menu.ln.ILNBasicMenu;
import menu.ln.ILNEnteMenu;
import menu.ln.ILNGroupMenu;
import menu.ln.ILNMenu;
import menu.ln.ILNPositionMenu;
import menu.ln.LNActionableMenu;
import menu.ln.LNAttackMenu;
import menu.ln.LNBasicMenu;
import menu.ln.LNEnteMenu;
import menu.ln.LNPositionMenu;
import menu.md.ActionableMenu;
import menu.md.AttackMenu;
import menu.md.BasicMenu;
import menu.md.EnteMenu;
import menu.md.PositionMenu;
import turner.md.IGameEvent;
import turner.md.ITurnerEvents;

public class PL_GamePlayerMenu {
	private ILNMenu[] menus;
	private ILNBasicMenu basicMenu;
	private ILNPositionMenu positionMenu;
	private ILNEnteMenu enteMenu;
	private ILNGroupMenu groupMenu;
	private ILNActionableMenu actionableMenu;

	
	private String loopMessage;
	
	public PL_GamePlayerMenu(String loopMessage, ILNGroupMenu groupMenu) {
//		BasicMenu bM = new BasicMenu();
//		this.basicMenu = new LNBasicMenu(bM);

		PositionMenu pM = new PositionMenu();
		this.positionMenu = new LNPositionMenu(pM);
		
		EnteMenu eM = new EnteMenu();
		this.enteMenu = new LNEnteMenu(eM);
		
		ActionableMenu actionMenu = new ActionableMenu();
		this.actionableMenu = new LNActionableMenu(actionMenu);
	
		
		this.groupMenu = groupMenu;
		
		menus = new ILNMenu[]{
			enteMenu,
			positionMenu,
			groupMenu,
			actionableMenu
//			basicMenu
			
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
