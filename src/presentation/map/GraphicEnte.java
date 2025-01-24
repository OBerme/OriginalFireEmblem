package presentation.map;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import entes.md.Ente;
import menu.md.Menu;
import presentation.graphicOptions.Menuable;

public class GraphicEnte extends JButton implements Menuable {
	private Ente ente;
	private String image;
	private Menu menu;
	
	public GraphicEnte(Ente ente, String pathImage, Menu menu, JPanel panel) {
		super(new ImageIcon(pathImage));
		this.ente = ente;
		this.menu = menu;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				showMenu(menu);
			}
		});
	}

	@Override
	public void showMenu(Menu menu) {
		int x = getX();
        int y = getY();
        System.out.println("Clic en: (" + x + ", " + y + ")");
	}
	
	
	
	
	
	
	
}
