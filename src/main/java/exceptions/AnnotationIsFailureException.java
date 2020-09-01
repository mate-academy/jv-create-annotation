package exceptions;

public class AnnotationIsFailureException extends RuntimeException {
    public AnnotationIsFailureException(String message) {
        super(message);
    }
}
