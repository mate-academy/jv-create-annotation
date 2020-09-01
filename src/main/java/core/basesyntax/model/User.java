package core.basesyntax.model;

public class User {
    private String name;
    private String password;
    private int age;
    private int id;

    public User(String name, String password, int age, int id) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name + '\''
                + ", age="
                + age
                + '}';
    }
}
