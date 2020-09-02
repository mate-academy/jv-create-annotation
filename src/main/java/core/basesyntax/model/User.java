package core.basesyntax.model;

import java.util.InvalidPropertiesFormatException;

public class User {
    private static final String REQUIRED_FORMAT = "[A-Za-z]+";
    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) throws InvalidPropertiesFormatException {
        formatCheck(name);
        formatCheck(surname);
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setName(String name) throws InvalidPropertiesFormatException {
        formatCheck(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws InvalidPropertiesFormatException {
        formatCheck(surname);
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User: " + name + " " + surname
                + ", " + age + " y.o.";
    }

    private void formatCheck(String input) throws InvalidPropertiesFormatException {
        if (!input.matches(REQUIRED_FORMAT)) {
            throw new InvalidPropertiesFormatException("Name and surname"
                    + " should consist of letters only");
        }
    }
}
