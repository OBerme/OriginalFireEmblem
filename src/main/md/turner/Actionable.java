package main.md.turner;

public interface Actionable {
	int getNumActions();
	boolean hasActions();
	void subtractNumActions(int numActions);
	void resetNumActions();
}
