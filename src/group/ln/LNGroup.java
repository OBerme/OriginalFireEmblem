package group.ln;

import entes.IEnteEvents;
import entes.md.Ente;
import group.md.Group;
import group.md.Groupable;
import group.md.IGroupEvents;
import turner.md.Actionable;
import turner.md.ITurnerEvents;
import turner.md.Turnable;

public class LNGroup implements IGroupEvents, ILNGroup, Actionable, IEnteEvents {
    private Group group;
    private  ITurnerEvents turnerEvents;    

    // Constructor
    public LNGroup(Group group,ITurnerEvents turnerEvents) {
        this.group = group;
        this.turnerEvents  = turnerEvents;
    }

    // Pre: the member should be in the group
    // Post: the member will be removed from the group
    @Override
    public void onMemberDies(Groupable member) {
        if(this.group.hasMember(member)) {
        	this.group.removeMember(member);
        }
    }
    
    public boolean isDone() {
    	return this.group.isDone();
    }

	@Override
	public int getNumActions() {
		int numActions = 0;
		for(Groupable nMemer : this.group.getTeam()) {
			if(nMemer instanceof Actionable) {
				Actionable nAction = (Actionable) nMemer;
				numActions += nAction.getNumActions();
			}
		}
		return numActions ;
	}

	@Override
	public boolean hasActions() {
		for(Groupable nMemer : this.group.getTeam()) {
			if(nMemer instanceof Actionable) {
				Actionable nAction = (Actionable) nMemer;
				if(nAction.getNumActions()>0)return true;
			}
		}
		return false;
	}

	public Group getGroup() {
		return group;
	}
	
	@Override
	public void subtractNumActions(int numActions) {
		
	}

	@Override
	public void resetNumActions() {
		for(Groupable nMemer : this.group.getTeam()) {
			if(nMemer instanceof Actionable) {
				( (Actionable) nMemer).resetNumActions();
				
			}
		}
	}

	@Override
	public void giveUp() {
		// TODO Auto-generated method stub
		this.group.setGiveUp(true);
	}

	@Override
	public void onEnteDies(Ente ente) {
		// TODO Auto-generated method stub
		this.group.removeMember((Groupable) ente);
		if(this.group.isDone()) {
			turnerEvents.onGiveUp();
		}
	}

	@Override
	public void onEnteReciveAtack(Ente ente) {
		// TODO Auto-generated method stub
		
	}
	
	

}