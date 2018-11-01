package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.Fakultas;
import com.flashdin.belajarspringweb.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fakultas")
public class FakultasController {



    @Autowired
    private FakultasService fakultasService;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Fakultas());
        return "/fakultas/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", fakultasService.findById(id));
        return "/fakultas/update";
    }

    @PostMapping(value = "/create")
    public String save(Fakultas param) {
        Fakultas data = fakultasService.save(param);
        if (data.getId() == 0) {
            return "redirect:/fakultas/create?failed";
        } else {
            return "redirect:/fakultas/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Fakultas param) {
        Fakultas data = fakultasService.update(param);
        if (data.getId() == 0) {
            return "redirect:/fakultas?ufailed";
        } else {
            return "redirect:/fakultas?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Fakultas param) {
        int data = fakultasService.delete(param);
        if (data == 0) {
            return "redirect:/fakultas?dfailed";
        } else {
            return "redirect:/fakultas?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", fakultasService.findAll());
        } else {
            Fakultas fakultas = new Fakultas();
            fakultas.setNama(param);
            model.addAttribute("dataSets", fakultasService.findByName(fakultas));
        }
        return "/fakultas/list";
    }
}
