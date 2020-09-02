package core.basesyntax.service.impl;

import core.basesyntax.model.User;
import core.basesyntax.service.Mapper;

public class UserMapperImpl implements Mapper<User> {
    @Override
    public User parse(String[] data) {
        if (data == null) {
            throw new RuntimeException("Expected to receive data, but got null");
        }
        try {
            String login = data[1];
            String password = data[2];
            int age = Integer.parseInt(data[3]);
            return new User(login, password, age);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect data");
        }
    }
}
