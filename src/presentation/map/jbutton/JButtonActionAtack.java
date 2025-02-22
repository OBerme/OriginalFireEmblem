package presentation.map.jbutton;

import javax.swing.ImageIcon;

import entes.md.GraphicEnte;
import mapa.md.IPosition;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.main.PDefaultValues;
import presentation.map.AbstractMapSizeFactory;
import presentation.map.IRelativePosition;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;


public class JButtonActionAtack implements IJButtonActionAtack{
	private PGraphicPositionInteger pGPI;
	private GraphicEnte gEnte;
	private IShowMenus isMenu;


	
	public JButtonActionAtack(PGraphicPositionInteger pGPI,
			GraphicEnte gEnte, IShowMenus isMenu) {
		this.pGPI = pGPI;
		this.gEnte = gEnte;
		this.isMenu = isMenu;
	}
	
	@Override
	public void setpGPI(PGraphicPositionInteger pGPI) {
		this.pGPI = pGPI;
	}

	@Override
	public void onClickListener() {
		if(this.gEnte instanceof Menuable) {
			if(PDefaultValues.DEBUG_MODE_JBUTTONS) System.out.println("The JButtonActionEnte was clicked");
			
			Menuable eMenu =  (Menuable)this.gEnte;
			
			IPMenu<Integer, Integer> menu = eMenu.getMenu();
			IRelativePosition nPosi = 
					AbstractMapSizeFactory.getRelativeIntegerPosition(pGPI.getgPosition(),1,0);
			this.isMenu.showMenu(menu, nPosi);
			
		}
	}
	
	
	
	



}
