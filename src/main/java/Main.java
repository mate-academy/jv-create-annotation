import controller.BetHandler;
import controller.ConsoleHandler;
import controller.UserHandler;

public class Main {

    public static void main(String[] args) {
        ConsoleHandler userConsoleHandler = new UserHandler();
        System.out.println("Enter nickname and password");
        userConsoleHandler.handle();
        ConsoleHandler betConsoleHandler = new BetHandler();
        System.out.println("Enter value and risk for your bet!");
        betConsoleHandler.handle();
    }
}
