package pl;

import java.util.List;

import acciones.md.ataque.Ataque;
import entes.Atacable;
import entes.md.Ente;
import group.md.Group;
import group.md.Groupable;
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
	
	public Ataque getAtack(Atacable atacable) {
		System.out.println("Give me the attack");
		List<Ataque> ataques = atacable.getAtacks();
		
		for(Ataque nAta : ataques) {
			System.out.println(nAta);
		}
		int iAtack = this.dataScanner.getInteger();
		
		Ataque sAtack = null;
		for(Ataque nAta : ataques) {
			if(nAta.getNum() == iAtack)
				sAtack = nAta;
		}
		if(sAtack != null)
			return sAtack;
		System.out.println("Please give me a valid attack");
		return getAtack(atacable);
	}
	
	 public Ente getEnte(Group playerGroup) {
		System.out.println("Give the number of the ente");
		Ente sEnte = enteScanner.getEnte();
		
		if(sEnte instanceof Groupable) {
			//to check if the ente is in the player lnPlayerGroup
			if(((Groupable)sEnte).getGroup().equals(playerGroup)){
				return sEnte;
			}
			System.out.println("You need to choose a ente from your group");
			return getEnte(playerGroup);
		}
		else {
			System.out.println("You need to choose a ente from a group");
			return getEnte(playerGroup);
		}
		
	 }
	 

	 public Ente getEnemyEnte(Group playerGroup) {
		System.out.println("Give the number of the ente");
		Ente sEnte = enteScanner.getEnte();
		
		if(sEnte instanceof Groupable) {
			//to check if the ente is in the player lnPlayerGroup
			if(!((Groupable)sEnte).getGroup().equals(playerGroup)){
				return sEnte;
			}
			System.out.println("You need to choose a ente from the other group");
			return getEnte(playerGroup);
		}
		else {
			System.out.println("You need to choose a ente from a group");
			return getEnte(playerGroup);
		}
		
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
