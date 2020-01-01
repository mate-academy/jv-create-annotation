import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import lib.Injector;

public class Main {
    {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Please insert Name, age, bet and risk");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        UserDao userDao = new UserDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(userDao.getAll());
    }
}
