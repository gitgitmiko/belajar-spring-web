package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.MahasiswaDAO;
import com.flashdin.belajarspringweb.dao.UserDAO;
import com.flashdin.belajarspringweb.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOImplTest {

    private UserDAO userDAO;
    private MahasiswaDAO mahasiswaDAO;
    private User param;

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAOImpl();

        param.setPassword("password");
        param.setUsername("username");

}

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByUsernameAndPassword() {
        User login = userDAO.findByUsernameAndPassword("username", "password");
        if (login != null) {
            System.out.println("Login success");
        } else {
            System.out.println("Login gagal");
        }
    }

    @Test
    public void find() {


    }

    @Test
    public void save() {
        userDAO.save(param);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByUsername() {
    }
}