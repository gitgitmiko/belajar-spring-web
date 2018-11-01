package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.Jurusan;
import com.flashdin.belajarspringweb.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jurusan")
public class JurusanController {



    @Autowired
    private JurusanService jurusanService;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Jurusan());
        return "/jurusan/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", jurusanService.findById(id));
        return "/jurusan/update";
    }

    @PostMapping(value = "/create")
    public String save(Jurusan param) {
        Jurusan data = jurusanService.save(param);
        if (data.getId() == 0) {
            return "redirect:/jurusan/create?failed";
        } else {
            return "redirect:/jurusan/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Jurusan param) {
        Jurusan data = jurusanService.update(param);
        if (data.getId() == 0) {
            return "redirect:/jurusan?ufailed";
        } else {
            return "redirect:/jurusan?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Jurusan param) {
        int data = jurusanService.delete(param);
        if (data == 0) {
            return "redirect:/jurusan?dfailed";
        } else {
            return "redirect:/jurusan?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", jurusanService.findAll());
        } else {
            Jurusan jurusan = new Jurusan();
            jurusan.setNama(param);
            model.addAttribute("dataSets", jurusanService.findByName(jurusan));
        }
        return "/jurusan/list";
    }
}
