package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.Mahasiswa;
import com.flashdin.belajarspringweb.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {



    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Mahasiswa());
        return "/mahasiswa/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", mahasiswaService.findById(id));
        return "/mahasiswa/update";
    }

    @PostMapping(value = "/create")
    public String save(Mahasiswa param) {
        Mahasiswa data = mahasiswaService.save(param);
        if (data.getId() == 0) {
            return "redirect:/mahasiswa/create?failed";
        } else {
            return "redirect:/mahasiswa/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Mahasiswa param) {
        Mahasiswa data = mahasiswaService.update(param);
        if (data.getId() == 0) {
            return "redirect:/mahasiswa?ufailed";
        } else {
            return "redirect:/mahasiswa?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Mahasiswa param) {
        int data = mahasiswaService.delete(param);
        if (data == 0) {
            return "redirect:/mahasiswa?dfailed";
        } else {
            return "redirect:/mahasiswa?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", mahasiswaService.findAll());
        } else {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNamaMhs(param);
            model.addAttribute("dataSets", mahasiswaService.findByName(mhs));
        }
        return "/mahasiswa/list";
    }
}
