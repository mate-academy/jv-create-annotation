package model;

public class User {
    private String email;
    private String accNumber;

    public User(String email, String accNumber) {
        this.email = email;
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "email='" + email + '\''
                + ", accNumber='" + accNumber + '\'' + '}';
    }
}
