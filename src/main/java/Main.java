import controller.ConsoleHandler;
import lib.Injector;

public class Main {
    public static void main(String [] args) {
        System.out.println("Please, input your bet, risk and name of horse"
                + " separated by a space (example: 1 1.1 Lola)");
        ConsoleHandler consoleHandler = new Injector.getInstance(ConsoleHandler.class);
        consoleHandler.handler();
    }
}
