package presentation.map.position;

import java.util.List;

import javax.swing.JComponent;

import mapa.md.IPosition;
import presentation.main.PDefaultValues;
import presentation.map.jbutton.IPGraphicPosition;

public class AbstractPositionModifier {
	public static void activateGraphicPositions(List<IPosition<Integer, Integer>> positions, 
			IPGraphicPosition<Integer, Integer>[][] gPositions) {
		for(IPosition<Integer, Integer> nPosi : positions) {
			(gPositions[nPosi.getX()][nPosi.getY()]).activePosition();;
		}
	}
}
