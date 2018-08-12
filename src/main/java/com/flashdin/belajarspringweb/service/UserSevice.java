package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.User;

import java.util.List;

public interface UserSevice extends BaseService<User> {

    public List<User> findByUsername(User param);

}
