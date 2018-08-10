package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspring.dao.UserDAO;
import com.flashdin.belajarspring.dao.impl.UserDAOImpl;
import com.flashdin.belajarspring.entity.User;
import com.flashdin.belajarspring.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserSevice {

    @Autowired
    private UserDAO userDAO = new UserDAOImpl();

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
}
