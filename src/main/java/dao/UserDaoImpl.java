package dao;

import db.Storage;
import exceptions.WrongPasswordException;
import java.util.List;
import java.util.NoSuchElementException;
import lib.Dao;
import model.Bet;
import model.User;

@Dao
public class UserDaoImpl implements UserDao {
    private List<User> storage = Storage.userStorage;
    private User user;

    @Override
    public User login(String userName, String password) {
        user = findUser(userName);
        if (user == null) {
            return register(userName, password);
        }
        if (user.getPassword().equals(password)) {
            System.out.println("Вы успешно авторизавались");
            return user;
        }
        throw new WrongPasswordException("Wrong password!");
    }

    @Override
    public User register(String userName, String password) {
        user = new User(userName, password);
        storage.add(user);
        System.out.println("Регистрация прошла успешно");
        return user;
    }

    @Override
    public List<Bet> getBetsByUserName(String userName) {
        user = findUser(userName);
        if (user != null) {
            return user.getBetsList();
        }
        throw new NoSuchElementException("User with this username does not exist");
    }

    private User findUser(String userName) {
        return storage.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findAny()
                .orElse(null);
    }
}
