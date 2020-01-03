package java.core.basesyntax.exception;

public class AnnotationNotFoundException extends RuntimeException {
    public AnnotationNotFoundException() {
        super("There isn't such annotation.");
    }
}
