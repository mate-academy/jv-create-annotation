import controler.ConsoleHandler;
import dao.BetDao;
import dao.PersonDao;
import exception.DaoNotExistsException;
import factory.BetFactory;
import factory.PersonFactory;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class App {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, DaoNotExistsException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Input value and risk for your bet");
        consoleHandler.handle();

        BetDao betDao = BetFactory.getBetDao();
        System.out.println("all bets" + betDao.getAll());

        PersonDao personDao = PersonFactory.getPersonDao();
        System.out.println("all persons" + personDao.getAll());
    }
}
