package presentation.map;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import entes.md.GraphicEnte;
import mapa.md.IPosition;
import mapa.md.IPositionable;
import mapa.md.Posicion;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.Menuable;
import presentation.main.PDefaultValues;

public class GraphicPosition<X, Y> implements IPosition<X, Y>{
	private ImageIcon cellImage;
	private GraphicMap<X, Y> map;
	private Posicion<X, Y> positi;
	//Pre: The ente 
	public GraphicPosition(Posicion<X, Y> positi,  String cellImage,  GraphicMap<X, Y> map) {
		this.positi = positi;
		
		this.cellImage = new ImageIcon(cellImage);
		this.map = map;
		// TODO Auto-generated constructor stub
	}
	
	
	public JComponent getGraphicRepresentation() {
		
		if(positi.hasSomething() && positi.getSomething() instanceof GraphicEnte) {
			GraphicEnte gEnte = (GraphicEnte)positi.getSomething();
			if(!gEnte.getEnte().isDied()) {
				return getEnteCell();
			}
		}
		return getCellButton();
	}
	
	
	private JButton getCellButton() {
		JButton button = new JButton();
		button.setIcon(cellImage);
		button.setBackground(PDefaultValues.D_CELL_COLOR_DESA);
		button.addActionListener(e -> {
			System.out.println(this.toString());
			button.setBackground(PDefaultValues.D_CELL_COLOR_ACTI);
		});
			
			
		
		return button;
	}
	
	private JButton getEnteCell() {
		return new PGraphicEnte((GraphicEnte)positi.getSomething(), map);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void setSomething(IPositionable positionable) {
		this.positi.setSomething(positionable);
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return positi.isEmpty();
	}


	@Override
	public boolean hasSomething() {
		// TODO Auto-generated method stub
		return positi.hasSomething();
	}


	@Override
	public IPositionable getSomething() {
		// TODO Auto-generated method stub
		return positi.getSomething();
	}


	@Override
	public X getX() {
		// TODO Auto-generated method stub
		return positi.getX();
	}


	@Override
	public Y getY() {
		// TODO Auto-generated method stub
		return positi.getY();
	}

}
