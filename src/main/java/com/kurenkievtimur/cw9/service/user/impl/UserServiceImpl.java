package com.kurenkievtimur.cw9.service.user.impl;

import com.kurenkievtimur.cw9.entity.User;
import com.kurenkievtimur.cw9.repository.UserRepository;
import com.kurenkievtimur.cw9.service.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository repository;

    @Override
    public User create(User user) {
        return saveOrUpdate(user);
    }

    @Override
    public User saveOrUpdate(User user) {
        return repository.save(user);
    }

    @Override
    public User delete(User user) {
        repository.delete(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
