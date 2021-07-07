package exceptions;

public class NoDaoAnnotationFound extends Exception {
    public NoDaoAnnotationFound(String message) {
        super(message);
    }
}
