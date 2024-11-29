package menu.md;
import java.util.ArrayList;

import menu.ln.IMenuShowable;
import menu.md.enums.ActionableMenuOptions;
import menu.md.enums.BasicMenuOptions;
import menu.md.enums.TypeGameMenuOptions;

public class TypeGameMenu extends Menu {


    // Método para obtener una opción de menú
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String exit = "";
    	for (TypeGameMenuOptions option : TypeGameMenuOptions.values()) {
    		exit += option + "\n";
        }	
    	return exit;
    }

	@Override
	public Integer[] getOptions() {
		
		TypeGameMenuOptions[] optionBM = TypeGameMenuOptions.values();
		Integer[] options = new Integer[optionBM.length];
		for(int i = 0; i < optionBM.length;i++) {
			options[i] = optionBM[i].getOption();
		}
	
		// TODO Auto-generated method stub
		return options;
	}

	@Override
	public void showMenu() {
		System.out.println(toString());
	}
}