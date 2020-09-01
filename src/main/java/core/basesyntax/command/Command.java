package core.basesyntax.command;

import core.basesyntax.exception.UserExistException;

public interface Command {
    public void execute(String[] data) throws UserExistException;
}
