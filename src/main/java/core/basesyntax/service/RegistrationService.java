package core.basesyntax.service;

import core.basesyntax.exception.DuplicateUserException;
import core.basesyntax.exception.InvalidAgeException;
import core.basesyntax.model.User;

public interface RegistrationService {
    void register(User newUser) throws DuplicateUserException, InvalidAgeException;
}
