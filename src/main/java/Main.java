import controller.ConsoleHandler;
import factory.BetDaoFactory;
import factory.PersonDaoFactory;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoClassDefFoundError {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Please type your value, risk, "
                + "person's name and ID, separated by space: ");
        consoleHandler.handle();

        System.out.println("All bets: " + BetDaoFactory.getBetDao().getAll());
        System.out.println("All people: " + PersonDaoFactory.getPersonDao().getAll());
    }
}
