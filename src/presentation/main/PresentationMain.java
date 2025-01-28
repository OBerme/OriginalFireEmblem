package presentation.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.GraphicMonstruo;
import entes.md.GraphicPersona;
import entes.md.Monstruo;
import entes.md.Persona;
import entes.md.SerVivo;
import group.ln.LNGroup;
import group.md.Group;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.IMapEvents;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.IPosition;
import mapa.md.MapaMatrixEnteGroupActionable;
import mapa.md.Posicion;
import mapa.md.PosicionGroupable;
import mapa.md.PosicionGroupableActionable;
import presentation.map.GraphicMap;
import presentation.map.GraphicMapInteger;
import presentation.map.GraphicPosition;
import turner.md.enums.TurnerEnumConstant;

public class PresentationMain {
	
	public static void main(String[] args) {
		 JFrame frame = new JFrame("Entes con Eventos de Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        
        int length = 5;
		List<Group> groupsR = new ArrayList();
//		groups.add(new Group())
		
		IPosition<Integer, Integer>[][] positions = new GraphicPosition[length][length];
		GraphicMapInteger gMap = null;
		 
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < length; j++) {	
				positions[i][j] = new GraphicPosition<Integer, Integer>(
						new PosicionGroupableActionable<Integer, Integer>(i, j), 
						PDefaultValues.getPathImage("casilla.png"), gMap);
			}
		}
		
		List<Ataque> ataquesN = new ArrayList<Ataque>();
		ataquesN.add(new Ataque(1, "Gun atack", 50000, Tipo.FUEGO));
		ataquesN.add(new Ataque(2, "Punietaso en las costillas", 200, Tipo.AGUA));
		
		List<Ataque> ataquesM = new ArrayList<Ataque>();
		ataquesM.add(new Ataque(1, "Magical atack", 50000, Tipo.FUEGO));
		ataquesM.add(new Ataque(2, "Garrazo en las costillas", 300, Tipo.FUEGO));
		
		((GraphicPosition<Integer,Integer>)positions[2][2]).setSomething(new GraphicPersona(
				new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesN),
				PDefaultValues.getPathImage("bluesky.png"), null)); //TODO
				
		((GraphicPosition<Integer,Integer>)positions[3][2]).setSomething(new GraphicPersona(
				new Persona(700, "Joji", "J", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesM),
				PDefaultValues.getPathImage("jiji.png"), null)); //TODO
		
		((GraphicPosition<Integer,Integer>)positions[2][3]).setSomething(new GraphicMonstruo(
				new Monstruo(1500, "Undyne", "U", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesN),
				PDefaultValues.getPathImage("monster.png"), null)); //TODO
		
		((GraphicPosition<Integer,Integer>)positions[3][3]).setSomething(new GraphicMonstruo(
				new Monstruo(2700, "Asgore", "A", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesN),
				PDefaultValues.getPathImage("monster.png"), null)); //TODO
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable(positions, groupsR);
		
		ILNMapaMatrixEntesGroup lnMapa = new LNMapaMatrixEntesGroup(mapa, null,null );
        // Crear el panel de dibujo
		
		gMap = new GraphicMapInteger(lnMapa);
        frame.add(gMap);
        
        frame.setSize(gMap.getWidth(), gMap.getHeight());

        // Mostrar la ventana
        frame.setVisible(true);
	}
}
