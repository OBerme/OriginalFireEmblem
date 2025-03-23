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

import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.IEnteEvents;
import entes.ln.ILNEntes;
import entes.ln.LNEntes;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.GraphicEnte;
import entes.md.GraphicMonstruo;
import entes.md.GraphicPersona;
import entes.md.IEnte;
import entes.md.Monstruo;
import entes.md.Persona;
import entes.md.SerVivo;
import group.ln.LNGroup;
import group.md.Group;
import mapa.ln.AbstractFactoryPositionInteger;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.IMapEvents;
import mapa.ln.IMapIntegerEvents;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.IPosition;
import mapa.md.MapaMatrixEnteGroupActionable;
import mapa.md.Posicion;
import mapa.md.PosicionGroupable;
import mapa.md.PosicionGroupableActionable;
import md.range.RangeDiagonal;
import md.range.Rombo;
import presentation.GAtack.AbstractFactoryGraphicAtack;
import presentation.GAtack.AbstractFactoryNormalAtack;
import presentation.GAtack.IAbstractFactoryGraphicAtack;
import presentation.GAtack.IAbstractFactoryNormalAtack;
import presentation.GAtack.IPAtackController;
import presentation.GAtack.IShowAtack;
import presentation.GAtack.IShowAtackCached;
import presentation.GAtack.IShowAtackDistance;
import presentation.GAtack.PAtackController;
import presentation.GAtack.PGraphicDistanceAtack;
import presentation.GAtack.PGraphicMeleAtack;
import presentation.MouseHoverAtackObserver.IHoverPositionAtackerObserver;
import presentation.MouseHoverAtackObserver.IHoverPositionAtackerSubject;
import presentation.MouseHoverAtackObserver.PositionAtackerHoverSubject;
import presentation.MouseHoverObserver.AtackerSubject;
import presentation.MouseHoverObserver.IAtackerObserver;
import presentation.MouseHoverObserver.IAtackerSubject;
import presentation.MouseHoverObserver.IMouseHoverObserver;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.MouseHoverObserver.MouseHoverSubject;
import presentation.ente.AbstractFactoryCharacterEnums;
import presentation.ente.AbstractFactoryCharacters;
import presentation.ente.AbstractFactoryGraphicCharacter;
import presentation.ente.AbstractFactoryGraphicCharacterEnums;
import presentation.ente.IAbstractFactoryCharacters;
import presentation.ente.IAbstractFactoryGraphicCharacters;
import presentation.ente.IAbstractFactoryNormalCharacter;
import presentation.ente.IGEnte;
import presentation.ente.PEnteController;
import presentation.graphicOptions.IShowMenus;
import presentation.main.controller.IPController;
import presentation.main.controller.PController;
import presentation.map.GraphicMapIntegerEnteAtackDistance;
import presentation.map.ILNGraphicMapIntegerAtackDistance;
import presentation.map.IPPPositionSubjectData;
import presentation.map.LNGraphicMapIntegerAtackDistance;
import presentation.map.jbutton.AbstractFactoryJButtonActions;
import presentation.map.jbutton.IAbstractFactoryJButtonActions;
import presentation.map.jbutton.IPGraphicPositionInteger;
import presentation.map.jbutton.PGraphicOPositionIntegerAtackDistance;
import presentation.map.jbutton.PGraphicPositionInteger;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.ILastPositionSubject;
import presentation.map.position.IObserver;
import presentation.map.position.LastPositionSubject;
import presentation.map.position.PPositionData;
import presentation.menu.PMenuAbstractFactory;
import presentation.menu.PShowMenuController;
import turner.ln.LNTurner;

public class PresentationMain {
	
	public static void main(String[] args) {
		 JFrame frame = new JFrame("Entes con Eventos de Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        int length = 5;
		
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable();
		
		//controls set up
		
		List<IObserver> posiObservers = new ArrayList<IObserver>();
		ILastPositionSubject lPSub = new LastPositionSubject();
		
		IShowMenus menuContro = new PShowMenuController(lPSub);
		
		IAtackerSubject atackSub = new AtackerSubject();
		IMouseHoverSubject mouseSubject = new MouseHoverSubject(atackSub);
		IHoverPositionAtackerSubject hPASubject = new PositionAtackerHoverSubject();
		
		atackSub.registerObserver((IAtackerObserver)mouseSubject);
		
		
		IPPPositionSubjectData subObserPositi = new PPositionData(posiObservers);
		
		IPController controller = new PController(subObserPositi, atackSub, mouseSubject, hPASubject);
		posiObservers.add((IObserver)controller);
		mouseSubject.registerObserver((IMouseHoverObserver)controller);
		hPASubject.registerObserver((IHoverPositionAtackerObserver)controller);
		
		
		IShowAtackCached sACached = (IShowAtackCached)controller;
		
		GraphicMapIntegerEnteAtackDistance gMap = null;
		 
		IPosition<Integer, Integer>[][] positions = new GraphicPositionInteger[length][length];
		IPGraphicPositionInteger[][] gPositions = new PGraphicPositionInteger[length][length];
		IAbstractFactoryJButtonActions fJButtonActions = new AbstractFactoryJButtonActions(menuContro);
		
		
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < length; j++) {	
				
				IPosition<Integer, Integer> nPositi = new GraphicPositionInteger(
						AbstractFactoryPositionInteger.getPositionInteger(i, j, mapa),
						PDefaultValues.getPathImage("casilla.png"),
						menuContro); //IShowMenus
				positions[i][j] = nPositi;
				
				
				IPGraphicPositionInteger nGPI = new PGraphicOPositionIntegerAtackDistance(
						(GraphicPositionInteger)nPositi, subObserPositi,
							fJButtonActions.getVoidAction() , mouseSubject,hPASubject);
				
				mouseSubject.registerObserver((IMouseHoverObserver)nGPI);
//				hPASubject.registerObserver((IHoverPositionAtackerObserver)nGPI); //we dont need for now
				
				posiObservers.add((IObserver)nGPI);
				
				gPositions[i][j] =nGPI;
			}
		}
		
		//SET UP THE MAP
		ILNMapaMatrixEntesGroup lnMapa = setUpGroupMap(length, null, null, null, new IMapIntegerEvents[] {}); //Empty for now
		
		
		try {
			gMap = new GraphicMapIntegerEnteAtackDistance(lnMapa, gPositions, 0, 0, fJButtonActions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ILNGraphicMapIntegerAtackDistance lnGMap = 
				new LNGraphicMapIntegerAtackDistance(gMap, lnMapa, menuContro, gMap);
		
		controller.setLnGMIAD(lnGMap);
		controller.setShowAtacks((IShowAtackDistance)lnGMap);

		IEnteEvents[] lnEnteEvents = new IEnteEvents[]{ //TODO improve and make an observer for killed entes
				(IEnteEvents)lnMapa,
				(IEnteEvents)gMap
//				(IEnteEvents)lnJojiGroup,
//				(IEnteEvents)lnOsquiGroup,
		};
		
		//SET UP ENTES
		ILNEntes lnEntes = new LNEntes(lnEnteEvents); 
		LNAccionesAtaque lnAccionesAtaque = new LNAccionesAtaque(lnEntes);

		IPAtackController ataContro = new PAtackController(lnAccionesAtaque, lnGMap,
				lPSub, (IShowAtackDistance)controller);
		posiObservers.add((IObserver)ataContro);
		
		
		IPEnteController entContro = new PEnteController(subObserPositi, lnMapa, lnGMap);
		posiObservers.add((IObserver)entContro); //TODOO fix the problem of posi observers		
		IAbstractFactoryPMenu mFactory = new PMenuAbstractFactory(entContro, ataContro, frame, controller, menuContro);
		
		
		
		//MOVING THE ENTES
		IAbstractFactoryNormalAtack afNA = new AbstractFactoryNormalAtack();
		IAbstractFactoryGraphicAtack afGA = 
				new AbstractFactoryGraphicAtack(gMap, afNA, (IShowAtackDistance)controller, mouseSubject, sACached );
		
		IAbstractFactoryNormalCharacter afC = new AbstractFactoryCharacters(afGA); //TODO TO SOLVE
		
		
		IAbstractFactoryGraphicCharacters afGC = new AbstractFactoryGraphicCharacter(afC, mFactory);
		
		List<IEnte> entesAdded = new ArrayList<IEnte>();
		
		
		IGEnte oscar = afGC.createEnte(AbstractFactoryGraphicCharacterEnums.G_OSCAR_NORMAL);
		entesAdded.add(oscar);
		
		
		lnGMap.moveEnte(oscar, 3,3);
		
		
		IGEnte jiji = afGC.createEnte(
				AbstractFactoryGraphicCharacterEnums.G_JIJI_NORMAL);
		entesAdded.add(jiji);
		lnGMap.moveEnte(jiji, 0,2);

        //Setup menus
        JLayeredPane layeredPane = new JLayeredPane();
        frame.setContentPane(layeredPane);
        
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
	}
	

	private static ILNMapaMatrixEntesGroup setUpGroupMap(int length, Group gr1, Group gr2
			,LNTurner lnTurner, IMapIntegerEvents[] iMapEvents) {
		
		List<LNGroup> groups = new ArrayList();
		List<Group> groupsR = new ArrayList();
		
		
		
//		groups.add(new Group())
		
		groupsR.add(gr1);
		groupsR.add(gr2);
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable(length, groupsR);
		
		groups.add(new LNGroup(gr1, lnTurner));
		groups.add(new LNGroup(gr2,lnTurner));
		

		ILNMapaMatrixEntesGroup lnMapa = new LNMapaMatrixEntesGroup(mapa, groups, iMapEvents);
		return lnMapa;
		
	}

	
}
