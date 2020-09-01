package core.basesyntax.service;

import core.basesyntax.command.Command;
import core.basesyntax.exception.InvalidCommandException;
import core.basesyntax.exception.UserExistException;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class CommandService {
    private Map<String, Command> commands;

    public void execute(String[] data) throws UserExistException, InvalidCommandException {
        Command command = commands.get(data[0]);
        if (command == null) {
            throw new InvalidCommandException();
        }
        command.execute(data);
    }
}
