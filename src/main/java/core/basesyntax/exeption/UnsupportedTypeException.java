package core.basesyntax.exeption;

public class UnsupportedTypeException extends RuntimeException {

    public UnsupportedTypeException(String errorMessage) {
        super(errorMessage);
    }
}
