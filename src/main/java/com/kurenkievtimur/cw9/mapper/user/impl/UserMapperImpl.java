package com.kurenkievtimur.cw9.mapper.user.impl;

import com.kurenkievtimur.cw9.dto.user.CreateUserDto;
import com.kurenkievtimur.cw9.dto.user.UserDto;
import com.kurenkievtimur.cw9.entity.User;
import com.kurenkievtimur.cw9.mapper.user.UserMapper;
import com.kurenkievtimur.cw9.service.role.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    PasswordEncoder encoder;
    RoleService service;

    @Override
    public UserDto convertEntityToDto(User user) {
        return UserDto.builder().id(user.getId()).build();
    }

    @Override
    public User convertDtoToEntity(CreateUserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .password(encoder.encode(userDto.getPassword()))
                .roles(Collections.singletonList(service.findById(userDto.getRoleId())))
                .build();
    }
}
