package main.pl.controller;

import main.ln.controller.scanner.LNDataScanner;
import main.ln.controller.scanner.LNEnteScanner;
import main.ln.controller.scanner.LNPositionScanner;
import main.ln.mapa.IEnteCollection;
import main.md.controller.scanner.DataScanner;
import main.md.controller.scanner.EnteScanner;
import main.md.controller.scanner.OwnScanner;
import main.md.controller.scanner.PositionScanner;
import main.md.ente.Ente;
import main.md.mapa.Posicion;

public class PL_GameScanner {
	private LNPositionScanner positionScanner;
	private LNDataScanner dataScanner;
	private LNEnteScanner enteScanner;
	
	
	public PL_GameScanner(OwnScanner scan, IEnteCollection iEnteColle) {
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
