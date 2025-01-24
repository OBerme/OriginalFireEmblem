package presentation.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import group.ln.LNGroup;
import group.md.Group;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.IMapEvents;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.MapaMatrixEnteGroupActionable;
import presentation.map.GraphicMap;
import presentation.map.GraphicMapInteger;

public class PresentationMain {
	
	public static void main(String[] args) {
		 JFrame frame = new JFrame("Entes con Eventos de Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        
        int length = 5;
		List<Group> groupsR = new ArrayList();
//		groups.add(new Group())
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable(length, groupsR);
		
		ILNMapaMatrixEntesGroup lnMapa = new LNMapaMatrixEntesGroup(mapa, null,null );
        // Crear el panel de dibujo
		
        GraphicMapInteger gMap = new GraphicMapInteger(lnMapa);
        frame.add(gMap);

        // Mostrar la ventana
        frame.setVisible(true);
	}
}
