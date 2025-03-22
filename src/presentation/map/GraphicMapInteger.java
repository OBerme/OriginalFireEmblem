package presentation.map;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.font.NumericShaper.Range;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import entes.md.GraphicEnte;
import entes.md.GraphicMonstruo;
import entes.md.GraphicPersona;
import entes.md.GraphicSerVivo;
import entes.md.Monstruo;
import group.md.Group;
import mapa.ln.AbstractFactoryPositionInteger;
import mapa.ln.INLMapa;
import mapa.ln.LNMapa;
import mapa.md.IPosition;
import mapa.md.IPositionable;
import mapa.md.Posicion;
import menu.md.Menu;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.ente.AbstractFactoryCharacters;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.graphicOptions.Playable;
import presentation.graphicOptions.Rangeable;
import presentation.main.PDefaultValues;
import presentation.map.jbutton.IJButtonAction;
import presentation.map.jbutton.IJButtonActionAtack;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.IPGraphicPositionInteger;
import presentation.map.jbutton.PGraphicPositionInteger;
import presentation.map.position.AbstractPositionModifier;
import presentation.map.position.GraphicPositionInteger;
import presentation.menu.PMenu;
import presentation.menu.PMenuAbstractFactory;

public class GraphicMapInteger extends GraphicMap<Integer, Integer> 
	implements Playable, Rangeable{

	protected INLMapa<Integer, Integer> lnMap;
	protected IPGraphicPositionInteger[][] gPositions;
	
	public GraphicMapInteger(INLMapa<Integer, Integer> map,
			IPGraphicPositionInteger[][] gPositions,
			int x, int y) {
		super();
		this.lnMap = map;
		this.gPositions = gPositions;
		this.setLayout(new GridLayout(map.getWidth(), map.getHeight()));
		
		this.setBounds(x,y, 
				getWidth() ,
				getHeight());
		createCells();
	}
//	
//	@Override 
//	public void createMap() {
//		createCells();
//	}
	
	public int getWidth() {
		return this.lnMap.getWidth()*PDefaultValues.REC_WIDTH;
	}
	
	public int getHeight() {
		return this.lnMap.getHeight()*PDefaultValues.REC_HEIGHT;
	}
	

	private void createCells() {
		// Crear botones para cada celda de la cuadrícula
		for(int x = 0; x < gPositions.length; x++) {
			for(int y = 0; y < gPositions[0].length; y++) {
				this.add((JComponent)gPositions[y][x]);
			}
		}
	}
	@Override 
	public void activateCells(List<IPosition<Integer, Integer>>  positions) {
		AbstractPositionModifier.activateGraphicPositions(positions, gPositions);
	}

	@Override
	public void refreshMap() {
		this.revalidate();
	    this.repaint();
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void showRange(Range range) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showPlayers(Group group) {
		
		
	}
	
	
	//Pre: The first fGPosition should contain the Ente
	@Override
	public void changePositions(IPGraphicPosition<Integer, Integer> fGPosition,
			IPGraphicPosition<Integer, Integer> sGPosition) {		
		IPositionable fSome =  fGPosition.getSomething();
		fGPosition.setSomething(sGPosition.getSomething());
		sGPosition.setSomething(fSome);
		
//		fgCPosi.get
		
		//Change the actions
		IJButtonAction fAction = fGPosition.getGraAction(); 
		((IJButtonActionAtack)fAction).setpGPI((IPGraphicPositionInteger)sGPosition); //Change the position
		
		fGPosition.setAction(sGPosition.getGraAction());		
		sGPosition.setAction(fAction);
		
		fGPosition.refreshButton();
		sGPosition.refreshButton();
		refreshMap();
	}


	@Override
	public IPosition<Integer, Integer> getPosition(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return gPositions[x][y].getgPosition();
	}


	@Override
	public String toStringNumberPositions() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setPosicion(Integer x, Integer y, IPosition<Integer, Integer> posicion) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public IPosition<Integer, Integer>[] getPosiciones() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isEmptyPosicion(IPosition<Integer, Integer> positionInteger) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setPosicion(IPosition<Integer, Integer> posi) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean hasPosition(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return lnMap.hasPositon(x,y);
	}

	@Override
	public IPGraphicPositionInteger getGraphicPosition(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return gPositions[x][y];
	}



	

}
