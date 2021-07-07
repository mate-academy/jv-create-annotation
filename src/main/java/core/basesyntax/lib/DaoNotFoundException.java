package core.basesyntax.lib;

public class DaoNotFoundException extends Throwable {
    public DaoNotFoundException() {
        System.out.println("@Dao not found");
    }
}
