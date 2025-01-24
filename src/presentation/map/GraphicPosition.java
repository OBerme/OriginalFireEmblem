package presentation.map;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import entes.md.GraphicEnte;
import mapa.md.Posicion;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;

public class GraphicPosition<X, Y> extends Posicion<X, Y>{
	private Image cellImage;
	private GraphicMap<X, Y> map;
	private GraphicEnte gEnte;
	
	//Pre: The ente 
	public GraphicPosition(X x, Y y, Image cellImage, GraphicEnte gEnte, GraphicMap<X, Y> map) {
		super(x, y);
		this.positionable = gEnte.getEnte();
		this.gEnte = gEnte;
		
		this.cellImage =cellImage;
		this.map = map;
		// TODO Auto-generated constructor stub
	}
	
	
	public JComponent getGraphicRepresentation() {
		if(hasEnte() && positionable.isDied()) {
			return getEnteCell();
		}
		return getCellButton();
	}
	
	
	private JButton getCellButton() {
		JButton button = new JButton(new ImageIcon(cellImage));
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Vamoooos hombre");
			}
		});
		
		return button;
	}
	
	private JButton getEnteCell() {
		return new PGraphicEnte(gEnte, map);
	}

}
