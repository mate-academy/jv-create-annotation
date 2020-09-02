package core.basesyntax.exception;

import java.io.IOException;

public class DaoAnnotationNotFound extends IOException {
    public DaoAnnotationNotFound(String message) {
        super(message);
    }
}
