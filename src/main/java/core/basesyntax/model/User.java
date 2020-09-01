package core.basesyntax.model;

import java.util.Objects;

public class User {
    private static int count = 0;
    private int userId;
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.userId = count++;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return userId == user.userId
                && Objects.equals(name, user.name)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, login, password);
    }

    @Override
    public String toString() {
        return "User"
                + "\n userId \t = \t" + userId
                + "\n name \t\t = \t" + name
                + "\n login \t\t = \t" + login
                + "\n password \t = \t" + password;
    }
}
