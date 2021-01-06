import controller.BetHandler;
import controller.ConsoleHandler;
import controller.UserHandler;

public class Main {

    public static void main(String[] args) {
        ConsoleHandler betHandler = new BetHandler();
        ConsoleHandler userHandler = new UserHandler();
        System.out.println("Enter nickname and password");
        userHandler.handle();
        System.out.println("Enter value and risk for your bet!");
        betHandler.handle();
    }
}
