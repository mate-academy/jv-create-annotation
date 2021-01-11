package core.basesyntax.model;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private String nickName;

    public User(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", nickName='" + nickName + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(nickName, user.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickName);
    }

    @Override
    public int compareTo(User user) {
        return this.nickName.compareTo(user.nickName);
    }
}
