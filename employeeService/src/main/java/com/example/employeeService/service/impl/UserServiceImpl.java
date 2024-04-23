package com.example.employeeService.service.impl;

import com.example.employeeService.domain.UserPrincipel;
import com.example.employeeService.repository.UserRepository;
import com.example.employeeService.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.nio.file.attribute.UserPrincipal;

@Service
public class UserServiceImpl implements UserDetailsService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (ObjectUtils.isEmpty(user))
            throw new UsernameNotFoundException("User Not Present");
        else
            return new UserPrincipel(user);
    }
}
