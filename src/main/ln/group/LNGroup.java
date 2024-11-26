package main.ln.group;

import main.md.group.Group;
import main.md.group.Groupable;
import main.md.group.IGroupEvents;
import main.md.turner.Actionable;
import main.md.turner.Turnable;

public class LNGroup implements IGroupEvents, ILNGroup, Actionable {
    private Group group;

    // Constructor
    public LNGroup(Group group) {
        this.group = group;
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
	
	

}