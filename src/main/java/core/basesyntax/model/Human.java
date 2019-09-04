package core.basesyntax.model;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;

    public Human(String name) {
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
        return "Human{" + "name='" + name + '\'' + '}';
    }
}
