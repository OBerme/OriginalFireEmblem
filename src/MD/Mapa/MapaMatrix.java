package MD.Mapa;

import MD.Ente.Ente;
import MD.Ente.Persona;

public  class MapaMatrix extends Mapa<Integer, Integer>  {
	private static final String ROW_STR = "-";
	private static final String COLUM_STR = "|";
	
	
	private Posicion<Integer, Integer>[][] mapa;
	private int length;

	public MapaMatrix(int length) {
		this.posiciones = new Posicion[length*length];
		this.mapa = generateMapa(length);
		this.length = length;
	}
	
	private Posicion<Integer, Integer>[][] generateMapa(int length){
		Posicion nPosi = null;
		
		Posicion<Integer, Integer>[][] eMap = new Posicion[length][length];
		
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < length; j++) {
				nPosi = new Posicion<Integer, Integer>(i, j, new Ente());
				posiciones[i*length+j] = nPosi;
				eMap[i][j] = nPosi;
			}
			
		}
		return eMap;
	}
	
	public Posicion<Integer, Integer>[][] getMapa() {
		return mapa;
	}
	
	@Override
	public String toString() {
		
		String exit = "";
		int countCharsEachPosition = 3;
		for(int j = 0 ; j < length; j++) {
			for(int i = 0 ; i < length*countCharsEachPosition; i++) {
				exit+= ROW_STR;
			}
			exit += "\n";
			
			for(int i = 0 ; i < length; i++) {
				exit += COLUM_STR +  mapa[i][j].toString() ;
				exit+= ( i +1 ) == length   ? COLUM_STR : "";
			}
			exit += "\n";
		}
		for(int i = 0 ; i < length*countCharsEachPosition; i++) {
			exit+= ROW_STR;
		}
		
		return exit;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int getHigh() {
		return this.length;
	}

	@Override
	public Posicion<Integer, Integer> getPosicion(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return mapa[x][y];
	}

	@Override
	public void setPosicion(Posicion<Integer, Integer> posicion) {
		this.mapa[posicion.getX()][posicion.getY()] = posicion;
		
	}

	@Override
	public boolean isEmptyPosicion(Posicion<Integer, Integer> posicion) {
		// TODO Auto-generated method stub
		
		return ! (getPosicion(posicion.getX(), posicion.getY()).getEnte() instanceof Persona);
	}
	
	

}
