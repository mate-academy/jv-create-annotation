package core.basesyntax.exception;

public class AnnotationNotFoundException extends RuntimeException {

    public AnnotationNotFoundException() {
        System.out.println("There is no annotation in the class");
    }
}
