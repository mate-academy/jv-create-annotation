package core.basesyntax.exeption;

public class NonAnnotationFoundException extends RuntimeException {
    public NonAnnotationFoundException(String massage) {
        super(massage);
    }
}
