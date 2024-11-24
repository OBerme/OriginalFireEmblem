package main.ln.controller.menu;

import java.awt.Menu;

import main.md.controller.menu.GroupMenu;
import main.md.group.Group;

public class LNGroupMenu implements ILNGroupMenu{
    
    private GroupMenu menu;
    protected IMenuShowable menuShowable;

    
    public LNGroupMenu(IMenuShowable menuShowable) {
        this.menuShowable = menuShowable;
    }
    
    // Constructor que recibe un menú y un OwnScanner
    public LNGroupMenu(GroupMenu menu,IMenuShowable menuShowable) {
        this.menu = menu;
        this.menuShowable = menuShowable;
    }
    
    public String getGroupMapString(Group sGroup) {
    	return this.menu.getGroupMapString(sGroup);
    }

    // Método para mostrar las opciones del menú
    public void showMenuOptions() {
    	menuShowable.showMenu();
    }

	@Override
	public Integer[] getMenuOptions() {
		return this.menu.getOptions();
	}

}