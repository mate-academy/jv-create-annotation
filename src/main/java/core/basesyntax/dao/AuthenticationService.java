//package core.basesyntax.dao;
//
//import core.basesyntax.model.User;
//
//public class AuthenticationService {
//    private final UserDao userDao;
//    public AuthenticationService(UserDao userDao) {
//        // we don't know who will create a userDao. It does not matter
//        this.userDao = userDao;
//    }
//
//    public void login(String login, String password) {
//
//        User user = userDao.findByLogin(login);
//        // AuthenticationService delegates the responsibility find user in DB to DAO layer
//        if (!user.getPassword().equals(password)) {
//            // here we are providing some business logic. This is the responsibility of AuthenticationService
//            throw new AuthenticationException("Login and/or password are not valid");
//        }
//        return user;
//    }
//}