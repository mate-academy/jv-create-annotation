package core.basesyntax.model;

public class Gamer {
    private String name;

    public Gamer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gamer{" + "name='" + name + '\'' + '}';
    }
}
