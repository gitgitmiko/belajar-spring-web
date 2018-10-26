package com.flashdin.belajarspringweb.repository;

import com.flashdin.belajarspringweb.entity.UserPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPass, Long> {
    UserPass findByUsername(String username);
}