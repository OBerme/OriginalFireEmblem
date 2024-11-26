package main.md.controller.menu;

import main.md.controller.menu.enums.AttackMenuOptions;

public class AttackMenu extends Menu {

    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String exit = "";
    	for (AttackMenuOptions option : AttackMenuOptions.values()) {
    		exit += option + "\n";
        }
    	return exit;
    }


	@Override
	public Integer[] getOptions() {
		// TODO Auto-generated method stub
		AttackMenuOptions[] optionsAM = AttackMenuOptions.values();
		Integer[] options = new Integer[optionsAM.length];
		for(int i=0; i<optionsAM.length;i++) {
			options[i] = optionsAM[i].getOption();
		}
 		return options;
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println(toString());
	}
}
