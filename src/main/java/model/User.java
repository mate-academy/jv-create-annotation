package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private List<Bet> betsList;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        betsList = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bet> getBetsList() {
        return betsList;
    }

    public void setBetsList(List<Bet> betsList) {
        this.betsList = betsList;
    }
}
