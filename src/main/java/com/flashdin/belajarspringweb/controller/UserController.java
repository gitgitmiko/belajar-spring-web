package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspring.entity.User;
import com.flashdin.belajarspring.service.UserSevice;
import com.flashdin.belajarspring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSevice userService = new UserServiceImpl();


    @GetMapping(value = "/user/create")
    public String viewCreate(Model model) {
        return "/user/create";
    }

    @GetMapping(value = "/user/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", userService.findById(id));
        return "dataSets";
    }

    @PostMapping(value = "/user/create")
    public String save(@RequestBody User param) {
        User data = userService.save(param);
        if (data == null) {
            return "redirect:/user/create?success=0";
        } else {
            return "redirect:/user/create?success=1";
        }
    }

    @PutMapping(value = "/user")
    public String update(@RequestBody User param) {
        User data = userService.update(param);
        if (data == null) {
            return "redirect:/user?usuccess=0";
        } else {
            return "redirect:/user?usuccess=1";
        }
    }

    @DeleteMapping(value = "/user")
    public String delete(@RequestBody User param) {
        int data = userService.delete(param);
        if (data == 0) {
            return "redirect:/user?dsuccess=0";
        } else {
            return "redirect:/user?dsuccess=1";
        }
    }

    @GetMapping(value = "/user")
    public String findAll(Model model) {
        model.addAttribute("dataSets", userService.findAll());
        return "dataSets";
    }

}
