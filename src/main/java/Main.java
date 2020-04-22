import controller.ConsoleHandler;
import dao.BetDao;
import dao.PersonDao;
import exception.AnnotationNotFoundException;
import factory.Factory;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String[] args) throws
            InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            AnnotationNotFoundException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstanse(ConsoleHandler.class);
        System.out.println("Enter value and risk for your bet");
        System.out.println("Enter your name, age and your coefficient of luck");
        handler.handle();
        BetDao betDao = Factory.getBetDao();
        PersonDao personDao = Factory.getPersonDao();
        System.out.println("all bets: " + betDao.getAll());
        System.out.println("all peoples: " + personDao.getAll());
    }
}
