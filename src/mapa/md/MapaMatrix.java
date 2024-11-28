package mapa.md;

import entes.Estado;
import entes.StateSerVivo;
import entes.md.Ente;
import entes.md.Monstruo;
import entes.md.Persona;

public  class MapaMatrix extends Mapa<Integer, Integer>  {
	protected static final String ROW_STR = "-";
	protected static final String COLUM_STR = "|";
	protected static final String EMPTY_STR = " ";
	
	
	protected Posicion<Integer, Integer>[][] mapa;
	protected int length;

	public MapaMatrix(int length) {
		this.posiciones = new Posicion[length*length];
		this.mapa = generateEmptyMap(length);
		this.length = length;
	}
	
//	private Posicion<Integer, Integer>[][] generateMapaWithEntes(int length){
//		Posicion nPosi = null;
//		
//		Posicion<Integer, Integer>[][] eMap = new Posicion[length][length];
//		
//		for(int i = 0 ; i < length; i++) {
//			for(int j = 0 ; j < length; j++) {
//				nPosi = new Posicion<Integer, Integer>(i, j, new Monstruo(200, "Mounstruo", "M", new Estado(StateSerVivo.NORMAL)));
//				posiciones[i*length+j] = nPosi;
//				eMap[i][j] = nPosi;
//			}
//			
//		}
//		return eMap;
//	}
	
	
	private Posicion<Integer, Integer>[][] generateEmptyMap(int length){
		Posicion<Integer, Integer>[][] eMap = new Posicion[length][length];
		
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < length; j++) {
				
				posiciones[i*length+j] = null;
				eMap[i][j] = null;
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
		String nChar = "";
		Posicion<Integer, Integer> nPosition;
		int countCharsEachPosition = 3;
		for(int j = 0 ; j < length; j++) {
			for(int i = 0 ; i < length*countCharsEachPosition; i++) {
				exit+= ROW_STR;
			}
			exit += "\n";
			
			for(int i = 0 ; i < length; i++) {
				nPosition = mapa[i][j];
				
				if(nPosition != null) 
					nChar = nPosition.hasEnte()  ? nPosition.getEnte().getShortName() :  EMPTY_STR;
				
				else
					nChar = EMPTY_STR;
				exit += COLUM_STR + nChar;  
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
				nPosition = mapa[i][j];
				
				if(nPosition != null) 
					nChar = nPosition.hasEnte()  ? nPosition.getEnte().getNumb()+"" :  EMPTY_STR ;
				
				else
					nChar = EMPTY_STR;
				exit += COLUM_STR + nChar;  
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
		setPosicion(posicion.getX(), posicion.getY(), posicion);
	}
	
	@Override
	public void setPosicion(Integer x, Integer y, Posicion<Integer, Integer> posicion) {
		this.mapa[x][y] = posicion;
		this.posiciones[x*length+y] = posicion;
	}

	@Override
	public boolean isEmptyPosicion(Posicion<Integer, Integer> posicion) {
		// TODO Auto-generated method stub
		Posicion<Integer, Integer> aPosi = getPosicion(posicion.getX(), posicion.getY());
		
		return aPosi == null || !(aPosi.getEnte() instanceof Persona);
	}
	
	/**
	 * The ente should be in the map and should be not null
	 * @param ente
	 * @return The position which the ente is right now 
	 *  null if the ente is not in the map
	 */
	public Posicion<Integer, Integer> getEntePosition(Ente ente){
		Posicion<Integer, Integer> position = null;
		for(Posicion<Integer, Integer> nPosition : posiciones) {
			if(nPosition != null && nPosition.hasEnte()) {
				Ente nEnte = nPosition.getEnte();
				if(nEnte.equals(ente)) {
					position = nPosition;
				}	
			}
		}
		return position;
	}
	
	

	/**
	 * Pre : Ente should be not null and should be in the map
	 */
	@Override
	public void onEnteDies(Ente ente) {
		Posicion<Integer, Integer> position = getEntePosition(ente);
		position.setEnte(null);		
	}


	
	
	
	

}
