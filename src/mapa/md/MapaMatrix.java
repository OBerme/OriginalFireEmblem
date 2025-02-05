package mapa.md;

import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.Monstruo;
import entes.md.Persona;

public  class MapaMatrix extends Mapa<Integer, Integer>  {
	protected static final String ROW_STR = "-";
	protected static final String COLUM_STR = "|";
	
	
	
	protected IPosition<Integer, Integer>[][] mapa;
	protected int length;
	
	public MapaMatrix() {
		this.length = 0;
		this.mapa = null;
		this.posiciones = null;
	}

	public MapaMatrix(int length) {
		generatePositions(length);
		this.length = length;
	}
	
	public MapaMatrix(IPosition<Integer, Integer>[][] positions) {
		this.mapa = positions;
		this.posiciones = convertMapToFlatMap(mapa);
		this.length = positions.length;
	}
	
	
	private void generatePositions(int length) {
		this.mapa = generateEmptyMap(length);
		this.posiciones = convertMapToFlatMap(mapa);
	}
	
	
	
	//Pre: the length should be more than 0 = lenght > 0
	//Post: it will return a map
	private IPosition<Integer, Integer>[][] generateEmptyMap(int length){
		IPosition<Integer, Integer>[][] eMap = new IPosition[length][length];
		
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < length; j++) {				
				eMap[i][j] = new Posicion<Integer, Integer>(i, j);
			}
			
		}
		return eMap;
	}
	
	//Pre: the matrixMap should have the same height in all the rows
	//Post: I will return a map with the same items as the matrix map,
	//		  it will not modified the original matrixMap
	private static IPosition<Integer, Integer>[] convertMapToFlatMap(IPosition<Integer, Integer>[][] matrixMap){
		int width = matrixMap.length;
		int height = matrixMap[0].length;
		IPosition<Integer, Integer>[] flatMap = new IPosition[width*height];		
		for(int i = 0 ; i < width; i++) {
			for(int j = 0 ; j < height; j++) {
				flatMap[i*width+j] = matrixMap[i][j];
			}
		}
		return flatMap;
	}
	
	public IPosition<Integer, Integer>[][] getMapa() {
		return mapa;
	}
	
	@Override
	public String toString() {
		
		String exit = "";
		String nChar = "";
		IPosition<Integer, Integer> nPosition;
		int countCharsEachPosition = 3;
		for(int j = 0 ; j < length; j++) {
			for(int i = 0 ; i < length*countCharsEachPosition; i++) {
				exit+= ROW_STR;
			}
			exit += "\n";
			
			for(int i = 0 ; i < length; i++) {
				nPosition = mapa[i][j];
				exit += COLUM_STR + ((Posicion<Integer,Integer>)nPosition).getRepresentation();  
				exit+= ( i +1 ) == length  ? COLUM_STR : "";
			}
			exit += "\n";
		}
		for(int i = 0 ; i < length*countCharsEachPosition; i++) {
			exit+= ROW_STR;
		}
		
		return exit;
	}
	
	@Override
	public String toStringWithNumber() {
		
		String exit = "";
		String nChar = "";
		Posicion<Integer, Integer> nPosition;
		int countCharsEachPosition = 3;
		for(int j = 0 ; j < length; j++) {
			for(int i = 0 ; i < length*countCharsEachPosition; i++) {
				exit+= ROW_STR;
			}
			exit += "\n";
			
			for(int i = 0 ; i < length; i++) {
				exit += COLUM_STR + ((Posicion<Integer,Integer>)mapa[i][j]).getRepresentation();  
				exit += ( i +1 ) == length  ? COLUM_STR : "";
			}
			exit += "\n";
		}
		for(int i = 0 ; i < length*countCharsEachPosition; i++) {
			exit+= ROW_STR;
		}
		
		return exit;
	}
	

	@Override
	public String toStringNumberPositions() {
		
		String exit = "";
		String nChar = "";
		Posicion<Integer, Integer> nPosition;
		int countCharsEachPosition = 5;
		for(int j = 0 ; j < length; j++) {
			for(int i = 0 ; i < length*countCharsEachPosition; i++) {
				exit+= ROW_STR;
			}
			exit += "\n";
			
			for(int i = 0 ; i < length; i++) {
				exit += COLUM_STR + i + "," + j;
				
				exit+= ( i +1 ) == length  ? COLUM_STR : "";
			}
			exit += "\n";
		}
		for(int i = 0 ; i < length*countCharsEachPosition; i++) {
			exit+= ROW_STR;
		}
		
		return exit;
	}
	
	@Override
	public int getWidth() {
		return this.length;
	}
	@Override
	public int getHeight() {
		return this.length;
	}

	@Override
	public IPosition<Integer, Integer> getPosicion(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return mapa[x][y];
	}

	@Override
	public void setPosicion(IPosition<Integer, Integer> posicion) {
		setPosicion(posicion.getX(), posicion.getY(), posicion);
	}
	
	@Override
	public void setPosicion(Integer x, Integer y, IPosition<Integer, Integer> posicion) {
		this.mapa[x][y] = posicion;
		this.posiciones[x*length+y] = posicion;
	}

	@Override
	public boolean isEmptyPosicion(IPosition<Integer, Integer> posicion) {
		// TODO Auto-generated method stub
		IPosition<Integer, Integer> aPosi = getPosicion(posicion.getX(), posicion.getY());
		
		return aPosi.isEmpty();
	}
	
	/**
	 * The ente should be in the map and should be not null
	 * @param ente
	 * @return The position which the ente is right now 
	 *  null if the ente is not in the map
	 */
	public IPosition<Integer, Integer> getEntePosition(Ente ente){
		IPosition<Integer, Integer> position = null;
		for(IPosition<Integer, Integer> nPosition : posiciones) {
			if( nPosition.hasSomething() && nPosition.getSomething() instanceof Ente) {
					Ente nEnte = (Ente) nPosition.getSomething();
					if(nEnte.equals(ente)) {
						position = nPosition;
						break;
					}	
				}
				
			}
		
		return position;
	}

	@Override
	public boolean hasPosition(Integer x, Integer y) {
		// TODO Auto-generated method stub
		
		if(x >= 0 && x < length) {
			return y >= 0 && y < length;
		}
		return false;	
	}

	

	
	
	
	

}
