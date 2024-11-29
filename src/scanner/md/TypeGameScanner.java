package scanner.md;

import java.util.Scanner;

import menu.md.TypeGameMenu;

public class TypeGameScanner {
	protected DataScanner dataScanner;
	private TypeGameMenu typeGameMenu;
	
	public TypeGameScanner(DataScanner dataScanner, TypeGameMenu typeGameMenu) {
		super();
		this.typeGameMenu = typeGameMenu;
		this.dataScanner = dataScanner;
	}

	public Scanner getScn() {
		return dataScanner.getScn();
	}
	
	public Integer getTypeGameOption() {
		boolean validOption = false;
		
		int optionChossen = this.dataScanner.getInteger();
		do {
			
			for(Integer nOption : typeGameMenu.getOptions()) {
				if(nOption.equals(optionChossen)) {
					validOption = true;
					break;
				}
			}
		}while(!validOption);
		
		return  optionChossen;
	}
	
	

	
	
}
