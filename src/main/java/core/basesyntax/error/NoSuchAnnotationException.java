package core.basesyntax.error;

public class NoSuchAnnotationException extends RuntimeException {

    public NoSuchAnnotationException(String errorMessage) {
        super(errorMessage);
    }
}
