package core.basesyntax.exception;

public class UserNotAuthorizedException extends Exception {
    public UserNotAuthorizedException(String message) {
        super(message);
    }
}
