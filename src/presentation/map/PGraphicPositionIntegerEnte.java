package presentation.map;

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
import menu.md.Menu;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.main.PController;
import presentation.main.PDefaultValues;
import presentation.menu.PMenu;
import presentation.menu.PMenuAbstractFactory;

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
		if(gEnte instanceof Menuable) {
			Menuable eMenu =  (Menuable)gEnte;
			return eMenu.getMenu();
		}
		return PMenuAbstractFactory.getDefaultMenuCell(null);
	}


	@Override
	public void update() {
		super.update();
		
	}
	

	protected void onClickedPosition() {
		
		if(this.gEnte instanceof Menuable) {
			Menuable eMenu =  (Menuable)this.gEnte;
			active = !active;
			
			if(active) {
				PMenu menu = eMenu.getMenu();
				
				this.isMenu.showMenu(menu);
			}
		}
		super.onClickedPosition();
		
	}	
}
