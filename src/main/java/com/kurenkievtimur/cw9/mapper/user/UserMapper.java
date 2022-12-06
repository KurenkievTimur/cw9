package com.kurenkievtimur.cw9.mapper.user;

import com.kurenkievtimur.cw9.dto.user.CreateUserDto;
import com.kurenkievtimur.cw9.dto.user.UserDto;
import com.kurenkievtimur.cw9.entity.User;
import com.kurenkievtimur.cw9.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<UserDto, User> {
    @Override
    UserDto convertEntityToDto(User user);

    User convertDtoToEntity(CreateUserDto userDto);
}
