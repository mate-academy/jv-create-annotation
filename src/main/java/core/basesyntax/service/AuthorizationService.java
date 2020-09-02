package core.basesyntax.service;

import core.basesyntax.exception.WrongLoginOrPasswordException;
import core.basesyntax.model.User;

public interface AuthorizationService {
    User authorize(String login, String password) throws WrongLoginOrPasswordException;
}
