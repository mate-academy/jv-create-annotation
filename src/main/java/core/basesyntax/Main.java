package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler(new BetDaoImpl(), new UserDaoImpl());
        handler.handle();
    }
}
