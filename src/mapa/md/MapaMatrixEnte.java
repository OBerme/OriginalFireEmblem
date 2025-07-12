package mapa.md;

import group.md.Group;

public class MapaMatrixEnte extends MapaMatrix{
	

	public MapaMatrixEnte(int length) {
		super(length);
	}
	

	public MapaMatrixEnte(IPosition<Integer, Integer>[][] positions) {
		super(positions);
	}
	

	public MapaMatrixEnte() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getEnteDesingNumber() {
		// TODO Auto-generated method stub

		String exit = "";
		String nChar = "";
		IPosition<Integer, Integer> nPosition;
		int countCharsEachPosition = 3;
		for(int y = 0 ; y < length; y++) {
			for(int x = 0 ; x < length*countCharsEachPosition; x++) {
				exit+= ROW_STR;
			}
			exit += "\n";
			
			for(int x = 0 ; x < length; x++) {
				nPosition = mapa[x][y];
				
				exit += COLUM_STR + nPosition.getRepresentationNumber();  
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
