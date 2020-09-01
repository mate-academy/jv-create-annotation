package core.basesyntax.exceptions;

public class NoAnnotationException extends RuntimeException {

    public NoAnnotationException() {
    }

    public NoAnnotationException(String errorMessage) {
        super(errorMessage);
    }
}
