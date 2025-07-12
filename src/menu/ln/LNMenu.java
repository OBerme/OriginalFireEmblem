package menu.ln;

import java.awt.Menu;

public abstract class LNMenu implements ILNMenu{
    
    private Menu menu;
    protected IMenuShowable menuShowable;

    
    public LNMenu(IMenuShowable menuShowable) {
        this.menuShowable = menuShowable;
    }
    
    // Constructor que recibe un menú y un OwnScanner
    public LNMenu(Menu menu) {
        this.menu = menu;
    }

    // Método para mostrar las opciones del menú
    public void showMenuOptions() {
    	menuShowable.showMenu();
    }

    // Método para verificar si una opción de menú es válida
    public String isMenuOption() {
        // Sin implementación
        return null;
    }

	@Override
	public abstract Integer[] getMenuOptions() ;

}