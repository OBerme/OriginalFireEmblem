package mapa.md;

import java.util.List;

import entes.md.Ente;
import entes.md.SerVivo;
import group.md.Group;
import group.md.Groupable;

public class MapaMatrixEnteGroup extends MapaMatrix {
	
	protected List<Group> groups;
	public MapaMatrixEnteGroup(int length, List<Group> groups) {
		super(length);
		// TODO Auto-generated constructor stub
		this.groups = groups;
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
				
				if(nPosition != null ) {
					nChar = EMPTY_STR;
					if(nPosition.hasEnte() ) {
						Ente ente = nPosition.getEnte();
						if(ente instanceof Groupable) {
							Groupable nMember = (Groupable)ente;
							if(nMember.getGroup().equals(sGroup))
								nChar = ente.getNumb()+"";
						}
					}
					
						
				}
					
				
				else
					nChar = EMPTY_STR;
				exit += COLUM_STR + nChar;  
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
