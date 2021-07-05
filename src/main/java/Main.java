import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Enter value and risk to make a new bet!");
        consoleHandler.handleBet();
        System.out.println("Enter login and email to register!");
        consoleHandler.handleUser();
    }
}
