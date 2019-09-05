import controller.ConsoleHandler;
import dao.BetDao;
import dao.UserDao;
import dao.daoImpl.BetDaoImpl;
import dao.daoImpl.UserDaoImpl;
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
        System.out.println("Для того, чтобы сделать ставку, введите \n " +
                "сумму, риск, имя клиента и пароль через пробел");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        UserDao userDao = new UserDaoImpl();
        System.out.println(betDao.getAll() + " " + userDao.getAll());
    }
}
