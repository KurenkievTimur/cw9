package com.kurenkievtimur.cw9.service.user;

import com.kurenkievtimur.cw9.entity.User;
import com.kurenkievtimur.cw9.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
    @Override
    User create(User user);

    @Override
    User saveOrUpdate(User user);

    @Override
    User delete(User user);

    @Override
    List<User> findAll();

    @Override
    User findById(Long id);
}
