package core.basesyntax.model;

import java.util.List;
import java.util.Objects;

public class User {
    private static int userId;
    private String name;
    private String login;
    private String password;

    public User(UserBuilder userBuilder) {
        userId = userBuilder.userId;
        name = userBuilder.name;
        login = userBuilder.login;
        password = userBuilder.password;
    }

    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static class UserBuilder {
        private int userId;
        private String name;
        private String login;
        private String password;

        public UserBuilder setUserId() {
            this.userId = User.userId++;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, password);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + '}';
    }
}
