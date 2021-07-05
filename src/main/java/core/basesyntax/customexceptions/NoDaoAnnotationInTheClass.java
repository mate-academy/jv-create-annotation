package core.basesyntax.customexceptions;

public class NoDaoAnnotationInTheClass extends Exception {
    public NoDaoAnnotationInTheClass(String message) {
        super(message);
    }
}
