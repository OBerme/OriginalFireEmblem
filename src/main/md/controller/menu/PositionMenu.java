package main.md.controller.menu;


import java.util.ArrayList;

import main.ln.controller.menu.IMenuShowable;
import main.md.controller.menu.enums.EnteMenuOptions;
import main.md.controller.menu.enums.PositionMenuOptions;

public class PositionMenu extends Menu{
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String exit = "";
		for (PositionMenuOptions option : PositionMenuOptions.values()) {
			exit += option + "\n";
        }	
		return exit;
	}
	

	@Override
	public Integer[] getOptions() {
		PositionMenuOptions[] optionBM = PositionMenuOptions.values();
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