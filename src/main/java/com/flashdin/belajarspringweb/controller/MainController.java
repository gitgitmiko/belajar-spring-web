package com.flashdin.belajarspringweb.controller;


import com.flashdin.belajarspringweb.entity.User;
import com.flashdin.belajarspringweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/do-login")
    public String doLogin(String username, String password) {
        User currentLogin = userService.findByUsernameAndPassword(username, password);
        if (currentLogin == null) {
            return "loginfailed";
        } else {
            return "menu";
        }
    }
}