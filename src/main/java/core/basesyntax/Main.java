package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import core.basesyntax.service.AuthorizationService;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.RegistrationService;
import core.basesyntax.service.impl.AuthorizationServiceImpl;
import core.basesyntax.service.impl.BetMapperImpl;
import core.basesyntax.service.impl.RegistrationServiceImpl;
import core.basesyntax.service.impl.UserMapperImpl;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        AuthorizationService authService = (AuthorizationService)
                Injector.getInstance(AuthorizationServiceImpl.class);
        RegistrationService regService = (RegistrationService)
                Injector.getInstance(RegistrationServiceImpl.class);
        Mapper<User> userMapper = new UserMapperImpl();
        Mapper<Bet> betMapper = new BetMapperImpl();
        consoleHandler.setAuthService(authService);
        consoleHandler.setRegService(regService);
        consoleHandler.setUserMapper(userMapper);
        consoleHandler.setBetMapper(betMapper);
        System.out.println("*** Welcome to 2xbet ***");
        consoleHandler.handle();
    }
}
