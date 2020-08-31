import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter 'bet' to make a new bet!");
        System.out.println("Enter 'user' to register!");
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.handle();
    }
}
