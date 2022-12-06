package com.kurenkievtimur.cw9.service.security.impl;

import com.kurenkievtimur.cw9.repository.UserRepository;
import com.kurenkievtimur.cw9.security.UserPrincipal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("%s doesn't exist", username))));
    }
}
