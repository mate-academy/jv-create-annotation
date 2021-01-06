import contoller.BetConsoleHandler;
import contoller.PersonConsoleHandler;

public class Main {
    public static void main(String[] args) {

        BetConsoleHandler betConsoleHandler = new BetConsoleHandler();
        betConsoleHandler.handleBet();
        PersonConsoleHandler personConsoleHandler = new PersonConsoleHandler();
        personConsoleHandler.handlePerson();
    }
}
