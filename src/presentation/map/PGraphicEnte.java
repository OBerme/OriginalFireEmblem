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
import presentation.graphicOptions.Menuable;

public class PGraphicEnte<X, Y> extends JButton {
	private GraphicEnte gEnte;
	private GraphicMap<X, Y> gMap;
	
	public PGraphicEnte(GraphicEnte gEnte, GraphicMap<X, Y> gMap) {
		//Set up the graphic options
		setIcon(new ImageIcon(gEnte.getPathImage()));
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(gEnte instanceof Menuable) {
					System.out.println("Graphic ente actived " + ((Menuable)gEnte).getMenu());
				}
			}
		});
		
		this.gEnte = gEnte;
		this.gMap = gMap;
	}

	
	
	
	
	
	
	
}
