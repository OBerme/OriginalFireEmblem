package presentation.map;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
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
import mapa.ln.INLMapa;
import mapa.ln.LNMapa;
import mapa.md.IPosition;
import mapa.md.IPositionEnte;
import mapa.md.IPositionable;
import mapa.md.Posicion;
import menu.md.Menu;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.graphicOptions.Playable;
import presentation.graphicOptions.Rangeable;
import presentation.main.AbstractFactoryCharacters;
import presentation.main.PDefaultValues;
import presentation.menu.PMenu;
import presentation.menu.PMenuAbstractFactory;

public class GraphicMapInteger extends GraphicMap<Integer, Integer> 
	implements Playable, Rangeable{

	private INLMapa<Integer, Integer> map;
	private IPGraphicPosition<Integer, Integer>[][] gPositions;
		
	public GraphicMapInteger(INLMapa<Integer, Integer> map,
			IPGraphicPosition<Integer, Integer>[][] gPositions,
			int x, int y) {
		super();
		this.map = map;
		this.gPositions = gPositions;
		this.setLayout(new GridLayout(map.getWidth(), map.getHeight()));
		this.setBounds(x,y, 
				getWidth() ,
				getHeight());
		createCells();
	}
	
	
	public int getWidth() {
		return this.map.getWidth()*PDefaultValues.REC_WIDTH;
	}
	
	public int getHeight() {
		return this.map.getHeight()*PDefaultValues.REC_HEIGHT;
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
	
	private void updateButtonListeners() {
	    for (int x = 0; x < gPositions.length; x++) {
	        for (int y = 0; y < gPositions[0].length; y++) {
	            JComponent component = (JComponent) gPositions[x][y];

	            if (component instanceof PGraphicPositionInteger) {
	                PGraphicPositionInteger button = (PGraphicPositionInteger) component;

	                // Primero, eliminamos todos los ActionListeners anteriores
	                for (ActionListener al : button.getActionListeners()) {
	                    button.removeActionListener(al);
	                }

	                // Asignamos un nuevo ActionListener basado en la nueva posición
	                button.addActionListener(e -> button.onClickedPosition());
	            }
	        }
	    }
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
	
	@Override
	public IPGraphicPosition<Integer, Integer> getGraphicPosition(IPosition<Integer, Integer> position){
		return gPositions[position.getX()][position.getY()];
	}
	
	@Override
	public void changePositions(IPGraphicPosition<Integer, Integer> fGPosition,
			IPGraphicPosition<Integer, Integer> sGPosition) {
		
		GraphicPositionInteger fgCPosi = (GraphicPositionInteger)fGPosition.getgPosition();
		GraphicPositionInteger sgCPosi = (GraphicPositionInteger)sGPosition.getgPosition();
		
		IPositionable fSome =  fgCPosi.getSomething();
		fgCPosi.setSomething(sgCPosi.getSomething());
		sgCPosi.setSomething(fSome);
		
		
		
		
		gPositions[fgCPosi.getX()][fgCPosi.getY()] = sGPosition;
		gPositions[sgCPosi.getX()][sgCPosi.getY()] = fGPosition;
		
//		sGPosition = fGPosition;
		fGPosition = sGPosition;
		
//		((JButton)sGPosition).setIcon(new ImageIcon(PDefaultValues.getPathImage("monster.png")));
		
//		Monstruo asgor =(Monstruo)AbstractFactoryCharacters.createAsgore();
//		
//		GraphicSerVivo gPerson = new GraphicMonstruo(
//				asgor,
//				PDefaultValues.getPathImage("monster.png"), 
//				PMenuAbstractFactory.getDefaultMenuEnte(asgor, null, null));
		
		
		
		fGPosition.setgPosition(sgCPosi);
		sGPosition.setgPosition(fgCPosi);
		
		
		refreshMap();
	}

	

}
