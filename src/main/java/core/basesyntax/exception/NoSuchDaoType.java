package core.basesyntax.exception;

public class NoSuchDaoType extends RuntimeException {
    public NoSuchDaoType(String errorMessage) {
        super(errorMessage);
    }
}
