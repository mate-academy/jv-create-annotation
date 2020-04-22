package core.basesyntax.exceptions;

public class NoDaoAnnotationException extends Exception {
    public NoDaoAnnotationException(String errorMessage) {
        super(errorMessage);
    }
}
