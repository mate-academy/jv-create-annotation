package core.basesyntax.exception;

public class AnnotationNotFoundException extends RuntimeException {
    public AnnotationNotFoundException() {
        super("Annotation not found!");
    }
}
