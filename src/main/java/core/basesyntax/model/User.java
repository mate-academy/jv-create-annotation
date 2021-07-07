package core.basesyntax.model;

public class User {
    private String username;
    private int userId;

    public User(String name, int id) {
        this.username = name;
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", userId=" + userId + '}';
    }
}
