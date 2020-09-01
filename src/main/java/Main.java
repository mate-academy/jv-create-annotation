import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Enter yours login, password, value, risk. Push ENTER! "
                + "After should write GO");
        handler.handle();

    }
}
