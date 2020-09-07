package core.basesyntax.model;

public class Player {
    private String firstName;
    private int id;

    public Player(String firstName, int id) {
        this.firstName = firstName;
        this.id = id;
    }

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{"
                + "firstName='" + firstName + '\''
                + ", id=" + id
                + '}';
    }
}
