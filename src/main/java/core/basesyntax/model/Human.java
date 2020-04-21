package core.basesyntax.model;

public class Human {
    private String name;
    private int years;

    public Human(String name, int years) {
        this.name = name;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Human{" + "name='" + name + '\'' + ", years=" + years + '}';
    }
}
