import controler.ConsoleHandler;
import dao.BetDao;
import dao.PersonDao;
import exeption.NoSuchDaoException;
import factory.Factory;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoSuchDaoException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Введіть ваше І'мя value та risk для вашої ставки ");
        handler.handle();
        BetDao betDao = Factory.getBetDao();
        PersonDao personDao = Factory.getPersonDao();
        System.out.println("all Persons " + personDao.getAll());
        System.out.println("all Bets " + betDao.getAll());
    }
}
