package menu.ln;

import menu.md.EnteMenu;
import menu.md.PositionMenu;

public class LNPositionMenu extends LNMenu implements ILNPositionMenu{
	private PositionMenu positionMenu;

	public LNPositionMenu(PositionMenu positionMenu) {
		super(positionMenu);
		this.positionMenu = positionMenu;
	}

	@Override
	public Integer[] getMenuOptions() {
		// TODO Auto-generated method stub
		return positionMenu.getOptions();
	}

}
