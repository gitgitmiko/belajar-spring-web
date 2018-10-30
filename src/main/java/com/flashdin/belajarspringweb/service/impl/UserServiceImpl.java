package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.UserDAO;
import com.flashdin.belajarspringweb.entity.User;
import com.flashdin.belajarspringweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User save(User param) {
        return userDAO.save(param);
    }

    @Override
    public User update(User param) {
        return userDAO.update(param);
    }

    @Override
    public int delete(User param) {
        return userDAO.delete(param);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public List<User> findByUsername(User param) {
        return userDAO.findByUsername(param);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }


}
