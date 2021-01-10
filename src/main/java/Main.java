import controller.ConsoleHandler;

public class Main {
    public static void main(String [] args) {
        System.out.println("Place, input your bet, risk and name of horse"
                + " separated by a space (example: 1 1.1 Lola)");
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.handler();
    }
}
