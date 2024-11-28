package group.md;

import java.util.List;

import player.md.Player;
import turner.md.Actionable;

public class Group {
    // Pre: The group key tiene que ser uno de la lista del equipo
	private Player player;
    private Groupable groupKey;
    private List<Groupable> team;
    private boolean giveUp;
    
    public Group(Groupable groupKey, Player player) {
        this.groupKey = groupKey;
        this.player = player;
        this.giveUp = false;
    }
    
    // Post: ----
    public Group(Groupable groupKey, List<Groupable> team, Player player) {
        this.groupKey = groupKey;
        this.team = team;
        this.player = player;
    }

    // Pre: El ente tiene que existir en el grupo
    // Post: Borrara del grupo el ente
    public void removeMember(Groupable ente) {
    	this.team.remove(ente);
    }

    // Pre: El ente no tiene que existir en el grupo
    // Post: aniadira al grupo el ente
    public void addMember(Groupable ente) {
    	team.add(ente);
    }

    // Pre:---
    //Post: devolvera si el grupo esta acabado
    public boolean isDone() {
        // Sin implementación
        return giveUp || groupKey.isDone();
    }
    
    public Player getPlayer() {
		return player;
	}

	public boolean hasMember(Groupable memberSearching) {
    	boolean isInGroup = false;
    	for(Groupable member : team) {
    		if(member.equals(memberSearching)) {
    			isInGroup = true;
    			break;
    		}
    			
    	}
    	return isInGroup;
    }
    
	
    
    
    public void setTeam(List<Groupable> team) {
		this.team = team;
	}

	@Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	if(obj == null || !( obj instanceof Group ) ) return false;
    	Group gObj = (Group) obj;
    	return this.player.getId() == gObj.getPlayer().getId();
    }

	public List<Groupable> getTeam() {
		return team;
	}

	public void setGiveUp(boolean giveUp) {
		this.giveUp = giveUp;
	}
	
	
	

}