package core.basesyntax.model;

public class Person {
    private String name;
    private int age;
    private double luck;

    public Person(String name, int age, double luck) {
        this.name = name;
        this.age = age;
        this.luck = luck;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getLuck() {
        return luck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", luck=" + luck
                + '}';
    }
}
