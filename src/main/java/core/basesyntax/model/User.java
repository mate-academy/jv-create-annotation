package core.basesyntax.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String surName;

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", surName='" + surName + '\''
                + '}';
    }
}
