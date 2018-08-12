package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User> {

    public List<User> findByUsername(User param);

}
