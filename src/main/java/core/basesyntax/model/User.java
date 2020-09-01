package core.basesyntax.model;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static boolean isLegalGambling(User user) {
        if (user == null) {
            System.out.println("Minimum user information in appropriate format "
                    + "must be provided to be sure you are allowed to make debts");
            return false;
        } else if (user.age < 21) {
            System.out.println("It's not legal to make debts under age of 21! "
                    + "But feel free to explore the app as a guest user");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
