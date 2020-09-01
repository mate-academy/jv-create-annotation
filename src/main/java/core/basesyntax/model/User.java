package core.basesyntax.model;

public class User {
    private String name;
    private String password;
    private int age;

    public User(int age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name + '\''
                + ", password='"
                + password + '\''
                + ", age="
                + age
                + '}';
    }
}
