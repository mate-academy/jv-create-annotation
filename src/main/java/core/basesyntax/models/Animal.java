package core.basesyntax.models;

public class Animal {
    String name;
    int healthpoints;

    public Animal(final String name, final int healthpoints) {
        this.name = name;
        this.healthpoints = healthpoints;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getHealthpoints() {
        return this.healthpoints;
    }

    public void setHealthpoints(final int healthpoints) {
        this.healthpoints = healthpoints;
    }
}
