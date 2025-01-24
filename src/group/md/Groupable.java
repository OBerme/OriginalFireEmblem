package group.md;
// Interfaz Groupable
public interface Groupable {
    void setGroup(Group group);
    Group getGroup();
    boolean isDone();
    String getGRepresentation();
}