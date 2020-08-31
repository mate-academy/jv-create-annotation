package core.basesyntax.service;

import core.basesyntax.model.User;
import core.basesyntax.model.UserDto;

public interface ModelMapper {
    User convertToUser(UserDto userDto);
    UserDto convertUserToDto(User user);
}
