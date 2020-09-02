package model;

public class User {
    private String name;
    private Double points;

    public User(String name, Double points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", points=" + points
                + '}';
    }
}
