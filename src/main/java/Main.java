import controller.BetHandler;
import controller.ConsoleHandler;
import controller.UserHandler;

public class Main {

    public static void main(String[] args) {
        ConsoleHandler userHandler = new UserHandler();
        System.out.println("Enter nickname and password");
        userHandler.handle();
        ConsoleHandler betHandler = new BetHandler();
        System.out.println("Enter value and risk for your bet!");
        betHandler.handle();
    }
}
