package presentation.map;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.font.NumericShaper.Range;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import group.md.Group;
import mapa.ln.INLMapa;
import mapa.ln.LNMapa;
import mapa.md.IPosition;
import mapa.md.Posicion;
import menu.md.Menu;
import presentation.graphicOptions.IShowMenus;
import presentation.graphicOptions.Menuable;
import presentation.graphicOptions.Playable;
import presentation.graphicOptions.Rangeable;
import presentation.main.PDefaultValues;
import presentation.menu.PMenu;

public class GraphicMapInteger extends GraphicMap<Integer, Integer> 
	implements Playable, Rangeable{

	private INLMapa<Integer, Integer> map;
	private IPGraphicPosition<Integer, Integer>[][] gPositions;
	
	
	
	public GraphicMapInteger(INLMapa<Integer, Integer> map, IPGraphicPosition<Integer, Integer>[][] gPositions) {
		super();
		this.map = map;
		this.gPositions = gPositions;
		this.setLayout(new GridLayout(map.getWidth(), map.getHeight()));
		
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
				this.add((JComponent)gPositions[x][y]);
			}
		}
	}

	@Override
	public void showMap() {
		
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
		// TODO Auto-generated method stub
		
	}

	

}
