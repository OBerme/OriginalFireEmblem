package presentation.map.jbutton;

import java.awt.Component;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

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
import presentation.menu.IPMenu;
import presentation.menu.PMenu;
import presentation.menu.PMenuAbstractFactory;


//Pre: ----
//Post: when the ente of this position dies should convert,
//		or cast, this PGraphicPositionEnte in a normal PGraphicPosition 
public class PGraphicPositionIntegerAtack 
	extends PGraphicPositionInteger implements IPGraphicPositionIntegerAtack{
	
	protected boolean actiAtack; //Shows if the cell is activate for an atack
	
	
	
	public PGraphicPositionIntegerAtack(IGraphicPosition<Integer, Integer> gPosition,
			IPPPositionSubjectData pSubject,
			IJButtonAction action) {
		super(gPosition, pSubject, action);
		this.actiAtack = false;

	}

	@Override
	public void activateAtack() {
		// TODO Auto-generated method stub
		
		actiAtack = true;
		setBackground(PDefaultValues.D_CELL_COLOR_ACTI_ATACK);
	}
	

	@Override
	public void update() {
		super.update();
		if(actiAtack) {
			if(!pSubject.getPosi().equals(gPosition)) {
				deactivateAtack();
			}
		}
		
	}
	

	
	protected void onClickedPosition() {
		if(actiAtack) {
			deactivateAtack();
		}
		super.onClickedPosition();
	}

	@Override
	public void deactivateAtack() {
		active = false;
		setBackground(PDefaultValues.D_CELL_COLOR_DEAC_ATACK);		
	}

	@Override
	public boolean isActive() {
		return actiAtack;
	}

	
}
