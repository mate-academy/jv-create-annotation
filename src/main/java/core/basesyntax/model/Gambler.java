package core.basesyntax.model;

public class Gambler {
    private String mail;

    public Gambler(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Gambler{mail=" + mail + '}';
    }
}
