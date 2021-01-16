package com.securitydb.security;

import com.securitydb.entity.User;
import com.securitydb.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipleDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipleDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);
        UserPrinciple userPrinciple = new UserPrinciple(user);
        return userPrinciple;
    }
}
