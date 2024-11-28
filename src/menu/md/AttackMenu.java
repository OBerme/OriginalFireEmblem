package menu.md;

import entes.md.*;
import menu.md.enums.AttackMenuOptionsMonstruo;
import menu.md.enums.AttackMenuOptionsPersona;

public class AttackMenu extends Menu {
	private Ente e;
	public AttackMenu(Ente e) {
		this.e=e;
	}

    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String exit = "";
		if(this.e instanceof Monstruo) {
			for (AttackMenuOptionsMonstruo option : AttackMenuOptionsMonstruo.values()) {
				exit += option + "\n";
			}
		}
		else if(this.e instanceof Persona) {
			for (AttackMenuOptionsPersona option : AttackMenuOptionsPersona.values()) {
				exit += option + "\n";
			}
    }
		return exit;
}


	@Override
	public Integer[] getOptions() {
		Integer[] options = null;
		// TODO Auto-generated method stub
		if(this.e instanceof Monstruo) {
			AttackMenuOptionsMonstruo[] optionsAM = AttackMenuOptionsMonstruo.values();
			options = new Integer[optionsAM.length];
			for(int i=0; i<optionsAM.length;i++) {
				options[i] = optionsAM[i].getOption();
			}
		} else if(this.e instanceof Persona) {
			AttackMenuOptionsPersona[] optionsAP = AttackMenuOptionsPersona.values();
			options = new Integer[optionsAP.length];
			for(int i=0; i<optionsAP.length;i++) {
				options[i] = optionsAP[i].getOption();
			}
		}
 		return options;
 		
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println(toString());
	}
}
