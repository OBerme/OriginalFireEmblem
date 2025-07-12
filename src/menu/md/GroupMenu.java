package menu.md;

import java.util.Scanner;

import group.md.Group;
import menu.md.enums.EnteMenuOptions;
import menu.md.enums.GroupMenuOptions;
import scanner.ln.ILNDataScanner;
import scanner.md.IGroupMap;
import scanner.md.BasicScanner;

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


