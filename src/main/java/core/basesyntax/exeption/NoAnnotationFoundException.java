package core.basesyntax.exeption;

public class NoAnnotationFoundException extends RuntimeException {
    public NoAnnotationFoundException(String massage) {
        super(massage);
    }
}
