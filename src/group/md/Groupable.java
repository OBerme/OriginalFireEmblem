package group.md;
// Interfaz Groupable
public interface Groupable {
    void setGroup(Group group);
    Group getGroup();
    int getNum();
    boolean isDone();
    String getGRepresentation();
}