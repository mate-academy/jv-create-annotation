package core.basesyntax.exception;

public class NoSuchDaoImplementationException extends RuntimeException {
    public NoSuchDaoImplementationException(String massage) {
        super(massage);
    }
}
