package presentation.map.jbutton;

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
import javax.swing.JFrame;
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
import presentation.map.IPPPositionSubjectData;
import presentation.map.position.IGraphicPosition;
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
			IJButtonAction action,
			GraphicEnte gEnte, IShowMenus isMenu) {
		
		super(gPosition, pSubject,new ImageIcon(gEnte.getPathImage()), action);
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


	
}
