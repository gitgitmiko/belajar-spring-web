package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.entity.UserPass;
import com.flashdin.belajarspringweb.repository.RoleRepository;
import com.flashdin.belajarspringweb.repository.UserRepository;
import com.flashdin.belajarspringweb.service.UserPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserPassServiceImpl implements UserPassService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserPass userpass) {
        userpass.setPassword(bCryptPasswordEncoder.encode(userpass.getPassword()));
        userpass.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(userpass);
    }

    @Override
    public UserPass findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}