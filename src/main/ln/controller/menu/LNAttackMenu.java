package main.ln.controller.menu;

import main.md.controller.menu.AttackMenu;

public class LNAttackMenu extends LNMenu implements ILNAttackMenu{
	
	private AttackMenu attackMenu;
	
	public LNAttackMenu(AttackMenu attackMenu) {
		super(attackMenu);
		this.attackMenu=attackMenu;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer[] getMenuOptions() {
		// TODO Auto-generated method stub
		return attackMenu.getOptions();
	}
    
	public void showMenuOptions() {
    	System.out.println(attackMenu.toString());
    }
	
}
