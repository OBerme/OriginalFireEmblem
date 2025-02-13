package presentation.map;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import entes.md.GraphicEnte;
import mapa.md.IPosition;
import mapa.md.IPositionable;
import mapa.md.Posicion;
import presentation.graphicOptions.IDrawable;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.main.IPEnteController;
import presentation.main.PController;
import presentation.main.PDefaultValues;
import presentation.menu.PMenuAbstractFactory;

public class GraphicPositionInteger implements IGraphicPosition<Integer, Integer>{
	private ImageIcon cellImage;
	private IShowMenus isMenu;
	private IPosition<Integer, Integer> positi;	
	
	
	//Pre: The ente 
	public GraphicPositionInteger(IPosition<Integer, Integer> positi, 
			String cellImage,  IShowMenus isMenu) {
		this.positi = positi;		
		this.cellImage = new ImageIcon(cellImage);
		this.isMenu = isMenu;
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
	public Integer getX() {
		// TODO Auto-generated method stub
		return positi.getX();
	}


	@Override
	public Integer getY() {
		// TODO Auto-generated method stub
		return positi.getY();
	}


	@Override
	public String getRepresentation() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRepresentationNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon getCellImage() {
		// TODO Auto-generated method stub
		return cellImage;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) return false;
		
		if(obj instanceof GraphicPositionInteger) {
			GraphicPositionInteger gpi = (GraphicPositionInteger)obj;
			return gpi.getX().equals(getX()) && gpi.getY().equals(getY());
		}
		return false;
	}

}
