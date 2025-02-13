package presentation.map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import entes.md.GraphicEnte;
import presentation.main.PDefaultValues;

public class PGraphicPositionInteger extends JButton implements IPGraphicPosition<Integer, Integer>, IPositionObserver {
	protected boolean active;
	protected IGraphicPosition<Integer, Integer> gPosition;
	protected IPPPositionSubjectData pSubject;
	
	
	public PGraphicPositionInteger(IGraphicPosition<Integer, Integer> gPosition, 
			IPPPositionSubjectData pSubject) {
		this(gPosition, pSubject ,gPosition.getCellImage());
	}
	
	public PGraphicPositionInteger(IGraphicPosition<Integer, Integer> gPosition, 
			IPPPositionSubjectData pSubject, Icon image) {
		super();
		this.gPosition = gPosition;
		this.pSubject = pSubject;
		this.active = false;
		
		setIcon(image);
		
		setBackground(PDefaultValues.D_CELL_COLOR_DESA);
		addActionListener(e -> {
			onClickedPosition();
		});
		
	}

	@Override
	public void update() {
		if(active) {
			if(!pSubject.getPosi().equals(gPosition)) {
				active = false;
				setBackground(PDefaultValues.D_CELL_COLOR_DESA);				
			}
		}
	}
	
	@Override
	public void activePosition() {
		active = !active;
		setBackground(active ? 
				PDefaultValues.D_CELL_COLOR_ACTI : PDefaultValues.D_CELL_COLOR_DESA);
	}
	
	
	protected void onClickedPosition() {
		active = !active;
		setBackground(active ? 
				PDefaultValues.D_CELL_COLOR_ACTI : PDefaultValues.D_CELL_COLOR_DESA);
		
		//Say that the button was clicked
		pSubject.setsPosi(gPosition);
	}
	
	
	
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
	
	
}
