package presentation.map;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import entes.md.Ente;
import entes.md.GraphicEnte;
import entes.md.GraphicSerVivo;
import mapa.md.IPosition;
import menu.md.Menu;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.main.PController;
import presentation.main.PDefaultValues;
import presentation.menu.PMenu;
import presentation.menu.PMenuAbstractFactory;


//Pre: ----
//Post: when the ente of this position dies should convert,
//		or cast, this PGraphicPositionEnte in a normal PGraphicPosition 
public class PGraphicPositionIntegerEnte extends PGraphicPositionInteger implements Menuable{
	private GraphicEnte gEnte;
	private IShowMenus isMenu;

	public PGraphicPositionIntegerEnte(IGraphicPosition<Integer, Integer> gPosition,
			IPPPositionSubjectData pSubject,
			GraphicEnte gEnte, IShowMenus isMenu) {
		
		super(gPosition, pSubject,new ImageIcon(gEnte.getPathImage()));
		this.gEnte = gEnte;
		this.isMenu = isMenu;
	}


	@Override
	public PMenu getMenu() {
		// TODO Auto-generated method stub
		if (gEnte instanceof Menuable) {
			Menuable eMenu =  (Menuable)gEnte;
			return eMenu.getMenu();
		}
		return PMenuAbstractFactory.getEmptyMenu();
	}


	@Override
	public void update() {
		super.update();
		
	}
	

	protected void onClickedPosition() {
		super.onClickedPosition();
		if(this.gEnte instanceof Menuable) {
			Menuable eMenu =  (Menuable)this.gEnte;
								
			if(active) {
				PMenu menu = eMenu.getMenu();
				
				this.isMenu.showMenu(menu, 
						//to move the menu to his site
						AbstractMapSizeFactory.getRelativeIntegerPosition(gPosition,0,1));
			}
		}
		
	}	
}
