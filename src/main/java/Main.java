import contoller.Authentication;
import contoller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите логин и пароль через пробел:");
        Authentication.authentication();
        System.out.println("Если хотите сделать ставку \n" + "введите сумму и риск через пробел:");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getAll());
    }
}
