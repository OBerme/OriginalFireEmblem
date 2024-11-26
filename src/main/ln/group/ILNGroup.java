package main.ln.group;

import main.md.group.IGroupEvents;

public interface ILNGroup extends IGroupEvents {
    
    // Pre: the group should be properly initialized
    // Post: returns true if the group is done, false otherwise
    boolean isDone();
    void giveUp();
}