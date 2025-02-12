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
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.main.IPEnteController;
import presentation.main.PController;
import presentation.main.PDefaultValues;
import presentation.menu.PMenuAbstractFactory;

public class GraphicPositionInteger implements IPosition<Integer, Integer>, IPositionObserver{
	private ImageIcon cellImage;
	private IShowMenus isMenu;
	private IPosition<Integer, Integer> positi;
	private IPEnteController ipContro;
	private IPPPositionSubjectData pPSubject;
	
	private boolean active;
	
	//Pre: The ente 
	public GraphicPositionInteger(IPosition<Integer, Integer> positi, 
			String cellImage,  IShowMenus isMenu,IPEnteController ipContro, IPPPositionSubjectData pPSubject) {
		this.positi = positi;
		
		
		this.cellImage = new ImageIcon(cellImage);
		this.isMenu = isMenu;
		this.ipContro =ipContro;
		this.pPSubject = pPSubject;;
		
		this.active = false;
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
			

			public void onClickedPosition() {
				
				active = !active;
				button.setBackground(active ? 
						PDefaultValues.D_CELL_COLOR_ACTI : PDefaultValues.D_CELL_COLOR_DESA);
				
				//Say that the button was clicked
				pPSubject.setsPosi(this);
			}
		});
			
			
		
		return button;
	}
	
	
	private JButton getEnteCell() {
		GraphicEnte gE = (GraphicEnte)positi.getSomething();
		return new PGraphicEnte(gE,isMenu);
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
	public void update() {
		// TODO Auto-generated method stub
		active = false;
		
	}

}
