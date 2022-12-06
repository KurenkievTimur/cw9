package com.kurenkievtimur.cw9.mapper.role.impl;

import com.kurenkievtimur.cw9.dto.role.RoleDto;
import com.kurenkievtimur.cw9.entity.Role;
import com.kurenkievtimur.cw9.mapper.role.RoleMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleDto convertEntityToDto(Role role) {
        return RoleDto.builder().id(role.getId()).name(role.getName().name()).build();
    }

    @Override
    public List<RoleDto> convertEntityToDto(List<Role> roles) {
        return roles.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
}
