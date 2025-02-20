package presentation.main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.GraphicEnte;
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
import md.range.RangeDiagonal;
import md.range.Rombo;
import presentation.GAtack.PGraphicMeleAtack;
import presentation.MouseHoverObserver.AtackerSubject;
import presentation.MouseHoverObserver.IAtackerSubject;
import presentation.MouseHoverObserver.IMouseHoverObserver;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.MouseHoverObserver.MouseHoverSubject;
import presentation.ente.AbstractFactoryCharacters;
import presentation.graphicOptions.IShowMenus;
import presentation.map.GraphicMap;
import presentation.map.GraphicMapInteger;
import presentation.map.GraphicMapIntegerAtack;
import presentation.map.GraphicMapIntegerAtackDistance;
import presentation.map.IGraphicMap;
import presentation.map.IGraphicMapAtack;
import presentation.map.IGraphicMapAtackDistance;
import presentation.map.IPPPositionSubjectData;
import presentation.map.jbutton.AbstractFactoryJButtonActions;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.PGraphicOPositionIntegerAtackDistance;
import presentation.map.jbutton.PGraphicPositionInteger;
import presentation.map.jbutton.PGraphicPositionIntegerAtack;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.IGraphicPosition;
import presentation.map.position.IObserver;
import presentation.map.position.IPPositionSubject;
import presentation.map.position.PPositionData;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;
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
		IPController controller = new PController(frame);
		IPEnteController entContro = (IPEnteController)controller; 
		IShowMenus menuContro = (IShowMenus)controller; 
		
		IAtackerSubject atackSub = new AtackerSubject();
		
		IMouseHoverSubject mouseSubject = new MouseHoverSubject(atackSub);
		
		List<IObserver> observers = new ArrayList<IObserver>();
		
		IPPPositionSubjectData subObserPositi = new PPositionData(observers);
		
		GraphicMapInteger gMap = null;
		 
		IPosition<Integer, Integer>[][] positions = new GraphicPositionInteger[length][length];
		IPGraphicPosition<Integer, Integer>[][] gPositions = new PGraphicPositionInteger[length][length];
		
		
		
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < length; j++) {	
				
				IPosition<Integer, Integer> nPositi = new GraphicPositionInteger(
						AbstractFactoryPositionInteger.getPositionInteger(i, j, mapa),
						PDefaultValues.getPathImage("casilla.png"),
						menuContro); //IShowMenus
				positions[i][j] = nPositi;
				
				
				gPositions[i][j] = new PGraphicOPositionIntegerAtackDistance(
						(GraphicPositionInteger)nPositi, subObserPositi, AbstractFactoryJButtonActions.getVoidAction(), mouseSubject);
				 
				observers.add((IObserver)gPositions[i][j]);
			}
		}
		
		
		
		
//		addEnteToPosition(new GraphicPersona(
//				jiji,
//				PDefaultValues.getPathImage("jiji.png"), 
//				PMenuAbstractFactory.getDefaultMenuEnte(jiji, entContro, frame //invoker  
//						)), 
//						((GraphicPositionInteger)positions[3][2])
//						, (PGraphicPositionInteger) gPositions[3][2],
//						menuContro, subObserPositi, observers);
		
//		//Undyne
//		Monstruo undy = (Monstruo)AbstractFactoryCharacters.createUndyne();
//		gPerson = new GraphicMonstruo(
//				undy,
//				PDefaultValues.getPathImage("monster.png"), 
//				PMenuAbstractFactory.getDefaultMenuEnte(undy, entContro, frame));
//		
//		gPosi =((GraphicPositionInteger)positions[2][3]); 
//		gPosi.setSomething(gPerson); 
//		
//		pgPosi = (PGraphicPositionInteger)gPositions[2][3]; 
//		pgPosi = new PGraphicPositionIntegerEnte(gPosi,
//				subObserPositi, AbstractFactoryJButtonActions.getEnteAction(pgPosi, 
//						gPerson, menuContro), gPerson, menuContro);
//		
//		observers.add((IObserver)pgPosi);
//		
//		//ASGORE
//		Monstruo asgor =(Monstruo)AbstractFactoryCharacters.createAsgore();
//		
//		gPerson = new GraphicMonstruo(
//				asgor,
//				PDefaultValues.getPathImage("monster.png"), 
//				PMenuAbstractFactory.getDefaultMenuEnte(asgor, entContro, frame));
//		
//		gPosi =((GraphicPositionInteger)positions[3][3]); 
//		gPosi.setSomething(gPerson); 
//		
//		pgPosi = (PGraphicPositionInteger)gPositions[3][3]; 
//		pgPosi = new PGraphicPositionIntegerEnte(gPosi,
//				subObserPositi, AbstractFactoryJButtonActions.getEnteAction(pgPosi, 
//						gPerson, menuContro), gPerson, menuContro);
//		
		//SET UP THE MAP
		mapa = new MapaMatrixEnteGroupActionable(positions, groupsR);
		ILNMapaMatrixEntesGroup lnMapa = new LNMapaMatrixEntesGroup(mapa, null,null );
		
		
		
		((PController)controller).setLnMMEG(lnMapa);
		
		
		
		
								
		
		
        // Crear el panel de dibujo
		
		gMap = new GraphicMapIntegerAtackDistance(lnMapa, gPositions,0,0);
		
		//Oscar
		AbstractFactoryCharacters abs = new AbstractFactoryCharacters((IGraphicMapAtack)gMap); //TODO TO SOLVE
		Persona person = (Persona)AbstractFactoryCharacters.createOscar();
		
		addEnteToPosition(new GraphicPersona(person,
				PDefaultValues.getPathImage("bluesky.png"),
				PMenuAbstractFactory.getDefaultMenuEnte(person, entContro, frame,controller))
				, 2, 2, positions, gPositions, menuContro, subObserPositi, observers, mouseSubject);
				
		//JIJI
		person = (Persona) AbstractFactoryCharacters.createJiji();
		
		addEnteToPosition(new GraphicPersona(person,
				PDefaultValues.getPathImage("bluesky.png"),
				PMenuAbstractFactory.getDefaultMenuEnte(person, entContro, frame, controller))
				, 3, 2, positions, gPositions, menuContro, subObserPositi, observers,mouseSubject);
		
		
		controller.setgMap(gMap);
		controller.setPosiProductor(subObserPositi);
		
		observers.add((IObserver)controller);
		
		
		
		gMap.createMap(); //To show the map
		
//        frame.add(gMap);
        
        //Setup menus
        JLayeredPane layeredPane = new JLayeredPane();
        frame.setContentPane(layeredPane);
//        
        layeredPane.add(gMap);

        layeredPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

        		Point point = MouseInfo.getPointerInfo().getLocation();
        		
            	if(PDefaultValues.DEBUG_MODE_PGPIAD) System.out.println("Prueba " + point);
//            	if(PDefaultValues.DEBUG_MODE_GMIMH) System.out.println("Positions reached" + e.getX() + "," + e.getY());
            }
        });
        
        frame.setSize(gMap.getWidth(), gMap.getHeight()+ PDefaultValues.HEADER_HEIGHT);
        
        
        
        // Mostrar la ventana
        frame.setVisible(true);
        
        ((PController) controller).setLastPosition(new Posicion<Integer, Integer>(2, 2));
        controller.showAtack( new PGraphicMeleAtack(
				new Ataque(1, "Gun atack", 50000, Tipo.FUEGO), (IGraphicMapAtack)gMap, new Rombo(1, gMap)));
       
	}

	
	private static void addEnteToPosition(GraphicEnte gPerson, int x, int y , 
			IPosition<Integer, Integer>[][] positions,  IPGraphicPosition<Integer, Integer>[][] gPositions,
			IShowMenus menuContro, IPPPositionSubjectData subObserPositi, 
			List<IObserver> observers, IMouseHoverSubject subjectMouse) {
		
		GraphicPositionInteger gPosi = (GraphicPositionInteger)positions[x][y];
		
		gPosi.setSomething(gPerson);
		
		PGraphicPositionInteger pgPosi = (PGraphicPositionInteger)gPositions[x][y];
		
		gPositions[x][y] = new PGraphicOPositionIntegerAtackDistance(gPosi,
				subObserPositi, AbstractFactoryJButtonActions.getEnteAction(pgPosi, 
						gPerson, menuContro), subjectMouse);
		
		observers.add((IObserver)gPositions[x][y]);
	}
	
	
	
}
