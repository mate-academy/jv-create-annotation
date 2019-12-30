package core.basesyntax.model;

public class Player {
    private String name;
    private int bank;

    public Player(String name, int bank) {
        this.name = name;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Player{"
                + "name='"
                + name
                + '\''
                + ", bank="
                + bank
                + '}';
    }
}
