package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static long idCount = 1;
    private long id;
    private String username;
    private String email;
    private String password;
    private List<Bet> userBets;

    public User(String username, String email, String password) {
        this.id = idCount++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userBets = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bet> getUserBets() {
        return userBets;
    }

    public void setUserBets(List<Bet> userBets) {
        this.userBets = userBets;
    }
}
