package core.basesyntax.service;

import core.basesyntax.model.User;
import core.basesyntax.model.UserDto;

public class UserDtoMapper implements ModelMapper {

    @Override
    public User convertToUser(UserDto userDto) {
        User.UserBuilder userBuilder = new User.UserBuilder();
        return userBuilder.setLogin(userDto.getLogin())
                .setPassword(userDto.getPassword())
                .setName(userDto.getPassword())
                .build();
    }

    @Override
    public UserDto convertUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        return userDto;
    }
}
