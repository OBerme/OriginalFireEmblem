package presentation.map.jbutton;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import entes.Movable;
import entes.md.GraphicEnte;
import presentation.main.PDefaultValues;
import presentation.map.IPPPositionSubjectData;
import presentation.map.position.IGraphicPosition;
import presentation.map.position.IPositionObserver;
import presentation.menu.PMenu;
import presentation.menu.PMenuAbstractFactory;
import turner.md.Actionable;

public class PGraphicPositionInteger extends JButton 
	implements IPGraphicPosition<Integer, Integer>, IPositionObserver {
	
	protected boolean active;
	protected IGraphicPosition<Integer, Integer> gPosition;
	protected IPPPositionSubjectData pSubject;
	private IJButtonAction action;
	private Icon image;
	
	public PGraphicPositionInteger(IGraphicPosition<Integer, Integer> gPosition, 
			IPPPositionSubjectData pSubject, IJButtonAction action) {
		this(gPosition, pSubject ,gPosition.getCellImage(),action);
	}
	
	public PGraphicPositionInteger(IGraphicPosition<Integer, Integer> gPosition, 
			IPPPositionSubjectData pSubject, Icon image, IJButtonAction action) {
		super();
		this.gPosition = gPosition;
		this.pSubject = pSubject;
		this.active = false;
		this.action = action;
		this.image = image;
		
		setIcon(image);
		
		setBackground(PDefaultValues.D_CELL_COLOR_DESA);
		
		addActionListener(e -> {
			onClickedPosition();
		});
		
		
	}
	
	
	public void setImage(Icon image) {
		this.image = image;
	}

	@Override
	public IJButtonAction getGraAction() {
		return action;
	}

	@Override
	public void setAction(IJButtonAction action) {
		this.action = action;
	}
	
	@Override
	public void refreshButton() {
		setIcon(gPosition.getCellImage());
		update();
	}

	@Override
	public void update() {
		if(active) {
			if(PDefaultValues.DEBUG_MODE_PPOSITIONS) System.out.println("The PPosition UPDATE " + this + "position ?" + gPosition);
			if(!pSubject.getPosi().equals(gPosition)) {
				active = false;
				setBackground(PDefaultValues.D_CELL_COLOR_DESA);				
			}
			if(PDefaultValues.DEBUG_MODE_PPOSITIONS) System.out.println("The PPosition UPDATE " + this + "isActive?" + active);
		}
		
	}
	
	@Override
	public void activePosition() {
		setActive(true);
		setBackground(PDefaultValues.D_CELL_COLOR_ACTI );
		if(PDefaultValues.DEBUG_MODE_PPOSITIONS) System.out.println("The PPosition ACTIVEPOSITION " + this + " isActive? " + active);
	}
	
	
	protected void onClickedPosition() {
		activePosition();
		
		//Say that the button was clicked
		pSubject.setsPosi(gPosition);
		action.onClickListener();
		
		if(PDefaultValues.DEBUG_MODE_PPOSITIONS) System.out.println("The PPosition " + this + "isActive?" + active);
	}
	
	
	@Override
	public void setgPosition(IGraphicPosition<Integer, Integer> gPosition) {
		this.gPosition = gPosition;
	}

	@Override
	public IGraphicPosition<Integer, Integer> getgPosition() {
		return gPosition;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) return false;
		
		if(obj instanceof PGraphicPositionInteger) {
			PGraphicPositionInteger pgpI = (PGraphicPositionInteger)obj;
			return pgpI.getgPosition().equals(getgPosition());
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PGraphicPositionInteger:" + gPosition.getX() + "," + gPosition.getY();
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return active;
	}

	public void setActive(boolean b) {
		this.active = b;
	}
	
	
	
	
	
}
