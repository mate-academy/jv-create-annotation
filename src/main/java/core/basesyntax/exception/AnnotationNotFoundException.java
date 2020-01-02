package core.basesyntax.exception;

public class AnnotationNotFoundException extends RuntimeException {
    public AnnotationNotFoundException() {
        super("Annotation is not found");
    }
}
