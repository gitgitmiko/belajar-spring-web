package com.flashdin.belajarspringweb.service;
import com.flashdin.belajarspringweb.entity.UserPass;

public interface UserPassService {
    void save(UserPass userpass);

    UserPass findByUsername(String username);
}
