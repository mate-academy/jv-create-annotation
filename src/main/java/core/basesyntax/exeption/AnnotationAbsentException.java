package core.basesyntax.exeption;

public class AnnotationAbsentException extends RuntimeException {

    public AnnotationAbsentException(String errorMessage) {
        super(errorMessage);
    }
}
