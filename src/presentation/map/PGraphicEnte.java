package presentation.map;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class PGraphicEnte<X, Y> extends JButton implements Menuable{
	private GraphicEnte gEnte;
	private IShowMenus isMenu;
	
	private boolean active;
	
	
	public PGraphicEnte(GraphicEnte gEnte, IShowMenus isMenu) {
		//Set up the graphic options
		setIcon(new ImageIcon(gEnte.getPathImage()));
		setBackground(PDefaultValues.D_CELL_COLOR_DESA);
		
		this.gEnte = gEnte;
		this.isMenu = isMenu;
		this.active = false;
		
		addActionListener(e -> {
			// TODO Auto-generated method stub
			if(this.gEnte instanceof Menuable) {
				Menuable eMenu =  (Menuable)this.gEnte;
				active = !active;
				
				if(active) {
					PMenu menu = eMenu.getMenu();
					
					this.isMenu.showMenu(menu);
				}
				
				setBackground(active ? 
						PDefaultValues.D_CELL_COLOR_ACTI : PDefaultValues.D_CELL_COLOR_DESA);
			}
		});
		
		
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
		active = false;
		// TODO Auto-generated method stub
		
	}
}
