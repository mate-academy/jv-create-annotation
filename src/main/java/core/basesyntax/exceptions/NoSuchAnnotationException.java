package core.basesyntax.exceptions;

public class NoSuchAnnotationException extends RuntimeException {
    public NoSuchAnnotationException(String annotationName) {
        super(annotationName + " annotation required");
    }
}
