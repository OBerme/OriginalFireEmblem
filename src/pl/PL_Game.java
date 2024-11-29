package pl;

import java.util.ArrayList;
import java.util.List;

import acciones.ln.LNAccionesAtaque;
import entes.Estado;
import entes.IEnteEvents;
import entes.StateSerVivo;
import entes.ln.ILNEntes;
import entes.ln.LNEntes;
import entes.md.Ente;
import entes.md.Monstruo;
import entes.md.Persona;
import entes.md.SerVivo;
import group.ln.LNGroup;
import group.md.Group;
import group.md.Groupable;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.MapaMatrixEnteGroup;
import mapa.md.MapaMatrixEnteGroupActionable;
import mapa.md.Posicion;
import player.ln.LNPlayer;
import player.md.Player;
import turner.ln.LNTurner;
import turner.md.IGameEvent;
import turner.md.ITurnerEvents;
import turner.md.Turnable;
import turner.md.Turner;
import turner.md.enums.TurnerEnumConstant;

public class PL_Game implements IGameEvent{
	
	
	private LNTurner lnTurner;
	private List<LNGroup> lnGroups;
	
	public PL_Game(LNTurner lnTurner, List<LNGroup> lnGroups) {
		this.lnGroups = lnGroups;
		this.lnTurner = lnTurner;
		this.lnTurner.setGameEvent(this);
		
		this.lnTurner.start();
	}
	



	@Override
	public void onGameEnds() {
		System.out.println("GameOver"
				+ "\nThe winner is");
		
		for(LNGroup nLNGroup : lnGroups) {
			if(!nLNGroup.isDone()) {
				System.out.println("The group of " + nLNGroup.getGroup().getPlayer());
			}
		}
	}
	
}
