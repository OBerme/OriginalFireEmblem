package main.md.controller.menu;

import java.util.Scanner;

import main.ln.controller.scanner.ILNDataScanner;
import main.md.controller.menu.enums.EnteMenuOptions;
import main.md.controller.menu.enums.GroupMenuOptions;
import main.md.controller.scanner.IGroupMap;
import main.md.controller.scanner.OwnScanner;
import main.md.group.Group;

public class GroupMenu extends Menu {
	private IGroupMap groupMap;
	
	public GroupMenu(IGroupMap groupMap) {
		this.groupMap = groupMap;
	}

    public String getGroupMapString(Group sGroup) {
    	return groupMap.getGroupMapString(sGroup);
    }
    
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		String exit = "";
		for (GroupMenuOptions option : GroupMenuOptions.values()) {
			exit += option + "\n";
        }	
		return exit;
	}
	
	@Override
	public Integer[] getOptions() {
		GroupMenuOptions[] optionBM = GroupMenuOptions.values();
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


