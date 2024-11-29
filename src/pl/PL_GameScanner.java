package pl;

import entes.md.Ente;
import mapa.ln.IEnteCollection;
import mapa.md.Posicion;
import scanner.ln.LNDataScanner;
import scanner.ln.LNEnteScanner;
import scanner.ln.LNPositionScanner;
import scanner.md.DataScanner;
import scanner.md.EnteScanner;
import scanner.md.BasicScanner;
import scanner.md.PositionScanner;

public class PL_GameScanner {
	private LNPositionScanner positionScanner;
	private LNDataScanner dataScanner;
	private LNEnteScanner enteScanner;
	
	
	public PL_GameScanner(BasicScanner scan, IEnteCollection iEnteColle) {
		dataScanner = new LNDataScanner(new DataScanner(scan.getScn()));
		enteScanner = new LNEnteScanner(new EnteScanner(scan.getScn(), dataScanner, iEnteColle));
		positionScanner = new LNPositionScanner(new PositionScanner(scan.getScn(), dataScanner));
	}
	
	public boolean confirms() {
		return dataScanner.confirms();
	}
	
	 public Ente getEnte() {
		return enteScanner.getEnte();
	 }
	 
	 public Posicion<Integer, Integer> getPosition() {
		 return positionScanner.getPosition();
	 }

	public boolean confims() {
		// TODO Auto-generated method stub
		return dataScanner.confirms();
	}

	public int getInteger() {
		// TODO Auto-generated method stub
		return dataScanner.getInteger();
	}
	
}
