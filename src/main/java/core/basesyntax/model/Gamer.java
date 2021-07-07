package core.basesyntax.model;

public class Gamer {
    private int age;
    private String nickname;

    public Gamer(int age, String nickname) {
        this.age = age;
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Model.Gamer {" + "age = " + age + ", nickname = " + nickname + "}";
    }
}
