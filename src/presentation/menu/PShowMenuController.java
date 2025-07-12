package presentation.menu;

import presentation.graphicOptions.IShowMenus;
import presentation.main.controller.IPController;
import presentation.map.IRelativePosition;
import presentation.map.position.ILastPositionSubject;

public class PShowMenuController 
	implements IShowMenus {
	private ILastPositionSubject posiSub;
	

	public PShowMenuController(ILastPositionSubject posiSub) {
		super();
		this.posiSub = posiSub;
	}


	@Override
	public void showMenu(IPMenu<Integer, Integer> menu, IRelativePosition position) {
		// TODO Auto-generated method stub
		posiSub.setLastPosition(position);
		menu.showMenu(position);
	}


	@Override
	public void showMenu(IPMenu<Integer, Integer> menu) {
		menu.showMenu(posiSub.getLastPosition());
		
	}

}
