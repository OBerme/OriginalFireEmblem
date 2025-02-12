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
import mapa.ln.AbstractFactoryPositionInteger;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.IMapEvents;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.IPosition;
import mapa.md.MapaMatrixEnteGroupActionable;
import mapa.md.Posicion;
import mapa.md.PosicionGroupable;
import mapa.md.PosicionGroupableActionable;
import presentation.graphicOptions.IShowMenus;
import presentation.map.GraphicMap;
import presentation.map.GraphicMapInteger;
import presentation.map.GraphicPositionInteger;
import presentation.map.IObserver;
import presentation.map.IPPPositionSubjectData;
import presentation.map.IPPositionSubject;
import presentation.map.PPositionData;
import presentation.menu.PMenuAbstractFactory;
import turner.md.enums.TurnerEnumConstant;

public class PresentationMain {
	
	public static void main(String[] args) {
		 JFrame frame = new JFrame("Entes con Eventos de Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        
        int length = 5;
		List<Group> groupsR = new ArrayList();
//		groups.add(new Group())
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable();
		
		//controls set up
		IPController controller = null;
		IPEnteController entContro = (IPEnteController)controller; 
		IShowMenus menuContro = (IShowMenus)controller; 
		
		List<IObserver> observers = new ArrayList<IObserver>();
		
		IPPPositionSubjectData obserPosition = new PPositionData(observers);
		
		
		
		GraphicMapInteger gMap = null;
		 
		IPosition<Integer, Integer>[][] positions = new GraphicPositionInteger[length][length];
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < length; j++) {	
				positions[i][j] = new GraphicPositionInteger(
						AbstractFactoryPositionInteger.getPosition(i, j, mapa),
						PDefaultValues.getPathImage("casilla.png"),
						menuContro, //IShowMenus
						entContro,
						obserPosition);
			}
		}
		
		List<Ataque> ataquesN = new ArrayList<Ataque>();
		ataquesN.add(new Ataque(1, "Gun atack", 50000, Tipo.FUEGO));
		ataquesN.add(new Ataque(2, "Punietaso en las costillas", 200, Tipo.AGUA));
		
		List<Ataque> ataquesM = new ArrayList<Ataque>();
		ataquesM.add(new Ataque(1, "Magical atack", 50000, Tipo.FUEGO));
		ataquesM.add(new Ataque(2, "Garrazo en las costillas", 300, Tipo.FUEGO));
		
		Persona oscar = new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesN);
		
		((GraphicPositionInteger)positions[2][2]).setSomething(
				new GraphicPersona(oscar,
					PDefaultValues.getPathImage("bluesky.png"),
					PMenuAbstractFactory.getDefaultMenuEnte(oscar, entContro))); //TODO
		
		Persona jiji = new Persona(700, "Joji", "J", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesM);
		((GraphicPositionInteger)positions[3][2]).setSomething(new GraphicPersona(
				jiji,
				PDefaultValues.getPathImage("jiji.png"), 
				PMenuAbstractFactory.getDefaultMenuEnte(jiji, entContro))); //TODO
		
		Monstruo undy = new Monstruo(1500, "Undyne", "U", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesN);
		((GraphicPositionInteger)positions[2][3]).setSomething(new GraphicMonstruo(
				undy,
				PDefaultValues.getPathImage("monster.png"), 
				PMenuAbstractFactory.getDefaultMenuEnte(undy, entContro))); //TODO
		
		Monstruo asgor =new Monstruo(2700, "Asgore", "A", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost(),ataquesN);
		((GraphicPositionInteger)positions[3][3]).setSomething(new GraphicMonstruo(
				asgor,
				PDefaultValues.getPathImage("monster.png"), 
				PMenuAbstractFactory.getDefaultMenuEnte(asgor, entContro))); //TODO
		
		mapa = new MapaMatrixEnteGroupActionable(positions, groupsR);
		ILNMapaMatrixEntesGroup lnMapa = new LNMapaMatrixEntesGroup(mapa, null,null );
        // Crear el panel de dibujo
		
		gMap = new GraphicMapInteger(lnMapa);
		
		controller = new PController(gMap, obserPosition);
		observers.add((IObserver)controller);
		
        frame.add(gMap);
        
        frame.setSize(gMap.getWidth(), gMap.getHeight());

        // Mostrar la ventana
        frame.setVisible(true);
	}
}
