package core.basesyntax;

import core.basesyntax.console.UserConsoleHandler;

public class UserBetApplication {
    public static void main(String[] args) {
        System.out.println("Please enter name, surname and your age split by space."
                + " If no data - q ");
        UserConsoleHandler userConsoleHandler = new UserConsoleHandler();
        userConsoleHandler.userConsole();
    }
}
