package main.md.controller.menu;


import main.md.controller.menu.enums.EnteMenuOptions;

public class EnteMenu extends Menu{
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String exit = "";
		for (EnteMenuOptions option : EnteMenuOptions.values()) {
			exit += option + "\n";
        }	
		return exit;
	}
	
	@Override
	public Integer[] getOptions() {
		EnteMenuOptions[] optionBM = EnteMenuOptions.values();
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