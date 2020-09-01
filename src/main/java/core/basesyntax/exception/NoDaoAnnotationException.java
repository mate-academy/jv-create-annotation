package core.basesyntax.exception;

public class NoDaoAnnotationException extends RuntimeException {
    public NoDaoAnnotationException(String message) {
        super(message);
    }
}
