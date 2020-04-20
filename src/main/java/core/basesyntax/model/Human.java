package core.basesyntax.model;

import core.basesyntax.library.Inject;

public class Human {
    @Inject
    private static String work;
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", work=" + work
                + '}';
    }
}
