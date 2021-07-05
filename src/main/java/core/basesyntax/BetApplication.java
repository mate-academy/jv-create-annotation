package core.basesyntax;

import core.basesyntax.console.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplementation;

public class BetApplication {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Please enter Name, Surname, Age, Bet value "
                + "and bet risk split by space. if no more bets - q");
        handler.readConsole();
        BetDao betDao = new BetDaoImplementation();// {
        //};
        System.out.println("bets" + betDao.getAll());
    }
}
