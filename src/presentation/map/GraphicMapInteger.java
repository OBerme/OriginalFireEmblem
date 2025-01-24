package presentation.map;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.font.NumericShaper.Range;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import group.md.Group;
import mapa.ln.INLMapa;
import mapa.ln.LNMapa;
import mapa.md.Posicion;
import menu.md.Menu;
import presentation.graphicOptions.Menuable;
import presentation.graphicOptions.Playable;
import presentation.graphicOptions.Rangeable;

public class GraphicMapInteger extends GraphicMap<Integer, Integer> implements Playable, Menuable, Rangeable{
	private static int REC_HEIGHT = 30; //in pxls
	private static int REC_WIDTH = 30; //in pxls
	private INLMapa<Integer, Integer> map;
	
	
	
	
	public GraphicMapInteger(INLMapa<Integer, Integer> map) {
		super();
		this.map = map;
		this.setLayout(new GridLayout(map.getWidth(), map.getHeight()));
		
	}
	
	private void createCells() {
		// Crear botones para cada celda de la cuadrícula
		for(Posicion<Integer, Integer> nPosi : positions) {
			if(nPosi != null) {
				if(nPosi.hasEnte()) {
					g.drawImage(new ImageIcon("entew.png").getImage(), REC_WIDTH*nPosi.getX(), REC_HEIGHT*nPosi.getY(), REC_WIDTH, REC_HEIGHT, this);	
				}	
			}
			else {
				g.drawImage(new ImageIcon("casilla.png").getImage(), REC_WIDTH*nPosi.getX(), REC_HEIGHT*nPosi.getY(), REC_WIDTH, REC_HEIGHT, this);
			}
		}
	}

	@Override
	public void showMap() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		// TODO Auto-generated method stub
		Posicion<Integer, Integer>[] positions = map.getPositions();
		
		for(Posicion<Integer, Integer> nPosi : positions) {
			if(nPosi != null) {
				if(nPosi.hasEnte()) {
					g.drawImage(new ImageIcon("entew.png").getImage(), REC_WIDTH*nPosi.getX(), REC_HEIGHT*nPosi.getY(), REC_WIDTH, REC_HEIGHT, this);	
				}	
			}
			else {
				g.drawImage(new ImageIcon("casilla.png").getImage(), REC_WIDTH*nPosi.getX(), REC_HEIGHT*nPosi.getY(), REC_WIDTH, REC_HEIGHT, this);
			}
		}
		
	}

	@Override
	public void showRange(Range range) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showPlayers(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu getMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
