package core.basesyntax.model.lib;

public class NoDaoAnnotationException extends RuntimeException {

    public NoDaoAnnotationException() {
    }

    public NoDaoAnnotationException(String message) {
        super(message);
    }

    public NoDaoAnnotationException(String message, Throwable cause) {
        super(message, cause);
    }
}
