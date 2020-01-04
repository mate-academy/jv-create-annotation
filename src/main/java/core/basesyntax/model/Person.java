package core.basesyntax.model;

public class Person {
    private String name;
    private int age;
    private int income;

    public Person(String name, int age, int income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\''
                + ", age=" + age + ", income=" + income + '}';
    }
}
