package core.basesyntax.model;

public class Person {
    private String name;
    private int cashBack;

    public Person(String name, int cashBack) {
        this.name = name;
        this.cashBack = cashBack;
    }

    public int getCashBack() {
        return cashBack;
    }

    public void setCashBack(int cashBack) {
        this.cashBack = cashBack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person {" + "name = '" + name + '\'' + ", cashBack = " + cashBack + '}';
    }
}
