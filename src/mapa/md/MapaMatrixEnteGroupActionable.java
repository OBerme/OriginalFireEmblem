package mapa.md;

import java.util.List;

import entes.md.Ente;
import group.md.Group;
import group.md.Groupable;
import turner.md.Actionable;

public class MapaMatrixEnteGroupActionable extends MapaMatrixEnteGroup{
	
	public MapaMatrixEnteGroupActionable(int length, List<Group> groups) {
		super(length, groups);
		// TODO Auto-generated constructor stub
	}
	

	public String getGroupMapString(Group sGroup) {
		// TODO Auto-generated method stub

		String exit = "";
		String nChar = "";
		Posicion<Integer, Integer> nPosition;
		int countCharsEachPosition = 3;
		for(int y = 0 ; y < length; y++) {
			for(int x = 0 ; x < length*countCharsEachPosition; x++) {
				exit+= ROW_STR;
			}
			exit += "\n";
			
			for(int x = 0 ; x < length; x++) {
				nPosition = mapa[x][y];				
				exit += COLUM_STR + ((PosicionGroupableActionable<Integer, Integer>)nPosition).getRepresentation();  
				exit+= ( x +1 ) == length  ? COLUM_STR : "";
			}
			exit += "\n";
		}
		for(int i = 0 ; i < length*countCharsEachPosition; i++) {
			exit+= ROW_STR;
		}
		
		return exit;
	}
}
