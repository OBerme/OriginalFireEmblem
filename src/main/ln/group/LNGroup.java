package main.ln.group;

import main.md.group.Group;
import main.md.group.Groupable;
import main.md.group.IGroupEvents;

public class LNGroup implements IGroupEvents, ILNGroup {
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
}