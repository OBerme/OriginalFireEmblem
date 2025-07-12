package presentation.map.jbutton;

import presentation.main.PDefaultValues;

public class JButtonActionVoid implements IJButtonAction {

	@Override
	public void onClickListener() {
		// VOID
		if(PDefaultValues.DEBUG_MODE_JBUTTONS) System.out.println("The JButtonActionVOID was clicked");
	}

}
