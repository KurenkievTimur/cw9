package com.kurenkievtimur.cw9.mapper.role;

import com.kurenkievtimur.cw9.dto.role.RoleDto;
import com.kurenkievtimur.cw9.entity.Role;
import com.kurenkievtimur.cw9.mapper.BaseMapper;

import java.util.List;

public interface RoleMapper extends BaseMapper<RoleDto, Role> {
    @Override
    RoleDto convertEntityToDto(Role role);

    List<RoleDto> convertEntityToDto(List<Role> roles);
}
