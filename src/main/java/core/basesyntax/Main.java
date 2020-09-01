package core.basesyntax;

import core.basesyntax.command.Command;
import core.basesyntax.command.RegistrationCommandImpl;
import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import core.basesyntax.service.CommandService;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        Map<String, Command> commands = new HashMap<>();
        commands.put("/r", (RegistrationCommandImpl) Injector.getInstance(RegistrationCommandImpl.class));

        CommandService commandService = new CommandService(commands);
        ConsoleHandler consoleHandler = new ConsoleHandler(commandService);
        System.out.println("*** Добро пожаловать на 2xBet ***");
        System.out.println("[ /h - помощь, /q - выход ]");


        consoleHandler.handle();
    }
}
