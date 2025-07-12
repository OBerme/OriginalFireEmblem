package menu.md;
import java.util.ArrayList;

import menu.ln.IMenuShowable;
import menu.md.enums.ActionableMenuOptions;
import menu.md.enums.BasicMenuOptions;

public class ActionableMenu extends Menu {


    // Método para obtener una opción de menú
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String exit = "";
    	for (ActionableMenuOptions option : ActionableMenuOptions.values()) {
    		exit += option + "\n";
        }	
    	return exit;
    }

	@Override
	public Integer[] getOptions() {
		
		ActionableMenuOptions[] optionBM = ActionableMenuOptions.values();
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