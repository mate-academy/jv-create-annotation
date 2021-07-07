package exceptions;

public class NoDaoAnnotatedFieldException extends Exception {

    public NoDaoAnnotatedFieldException(String errorMessage) {
        super(errorMessage);
    }
}
