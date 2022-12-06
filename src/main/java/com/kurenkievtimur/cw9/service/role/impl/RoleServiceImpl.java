package com.kurenkievtimur.cw9.service.role.impl;

import com.kurenkievtimur.cw9.entity.Role;
import com.kurenkievtimur.cw9.repository.RoleRepository;
import com.kurenkievtimur.cw9.service.role.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    RoleRepository repository;

    @Override
    public Role create(Role role) {
        return saveOrUpdate(role);
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return repository.save(role);
    }

    @Override
    public Role delete(Role role) {
        repository.delete(role);
        return role;
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return null;
    }
}
