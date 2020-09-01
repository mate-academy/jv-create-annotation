package core.basesyntax;

import core.basesyntax.controller.BetConsoleHandler;
import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.controller.UserConsoleHandler;
import core.basesyntax.db.Storage;
import core.basesyntax.lib.Injector;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.lang.reflect.InvocationTargetException;

/**
 * Feel free to remove this class and create your own.
 */
public class Application {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        ConsoleHandler userConsoleHandler = (ConsoleHandler) Injector
                .getInstance(UserConsoleHandler.class);
        userConsoleHandler.handle();
        for (User user : Storage.USERS_STORAGE) {
            System.out.println(user.toString());
        }
        ConsoleHandler betConsoleHandler = (ConsoleHandler) Injector
                .getInstance(BetConsoleHandler.class);
        betConsoleHandler.handle();
        for (Bet bet : Storage.BETS_STORAGE) {
            System.out.println(bet.toString());
        }
    }
}
