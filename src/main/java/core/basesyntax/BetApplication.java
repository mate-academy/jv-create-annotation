package core.basesyntax;

import core.basesyntax.console.ConsoleHandler;

public class BetApplication {
    public static void main(String[] args) {
        System.out.println("Please enter Bet value and bet risk. if no more bets - q");
        ConsoleHandler handler = new ConsoleHandler();
        handler.readConsole();
    }
}
