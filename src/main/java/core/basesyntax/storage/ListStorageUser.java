package core.basesyntax.storage;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import core.basesyntax.model.UserDto;
import core.basesyntax.service.ModelMapper;
import core.basesyntax.service.UserDtoMapper;

import java.util.ArrayList;
import java.util.List;

public class ListStorageUser {
    public static List<User> userList = new ArrayList<>();
    public void addUser(UserDto userDto) {
        ModelMapper modelMapper = new UserDtoMapper();
        userList.add(modelMapper.convertToUser(userDto));
        System.out.println("User added.");
    }
}
