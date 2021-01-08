package core.basesyntax.exceptions;

public class NoAnnotationPresentException extends RuntimeException {
    public NoAnnotationPresentException(String message, Class clazz) {
        super(message + clazz.toString());
    }
}
