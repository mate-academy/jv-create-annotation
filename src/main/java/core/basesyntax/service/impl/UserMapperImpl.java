package core.basesyntax.service.impl;

import core.basesyntax.model.User;
import core.basesyntax.service.Mapper;

public class UserMapperImpl implements Mapper<User> {
    @Override
    public User parse(String[] data) throws NumberFormatException {
        if (data == null) {
            throw new RuntimeException("Expected to receive data, but got null");
        }
        String login = data[1];
        String password = data[2];
        int age = Integer.parseInt(data[3]);
        return new User(login, password, age);
    }
}
