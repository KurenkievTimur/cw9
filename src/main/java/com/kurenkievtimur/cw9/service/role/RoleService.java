package com.kurenkievtimur.cw9.service.role;

import com.kurenkievtimur.cw9.entity.Role;
import com.kurenkievtimur.cw9.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    @Override
    Role create(Role role);

    @Override
    Role saveOrUpdate(Role role);

    @Override
    Role delete(Role role);

    @Override
    Role findById(Long id);

    @Override
    List<Role> findAll();
}
