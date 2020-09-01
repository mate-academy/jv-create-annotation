package dao;

import db.UserStorage;
import exceptions.WrongPasswordException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import model.Bet;
import model.User;

public class UserDaoImpl implements UserDao {
    private Map<String, User> storage = UserStorage.userStorage;
    private User user;

    @Override
    public User login(String userName, String password) {
        if (!storage.containsKey(userName)) {
            return register(userName, password);
        }
        user = storage.get(userName);
        if (user.getPassword().equals(password)) {
            System.out.println("Вы успешно авторизавались");
            return user;
        }
        throw new WrongPasswordException("Wrong password!");
    }

    @Override
    public User register(String userName, String password) {
        user = new User(userName, password);
        storage.put(userName, user);
        System.out.println("Регистрация прошла успешно");
        return user;
    }

    @Override
    public List<Bet> getBetsByUserName(String userName) {
        if (storage.containsKey(userName)) {
            return storage.get(userName).getBetsList();
        }
        throw new NoSuchElementException("User with this username does not exist");
    }
}
