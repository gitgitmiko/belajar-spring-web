package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.FakultasDAO;
import com.flashdin.belajarspringweb.entity.Fakultas;
import com.flashdin.belajarspringweb.entity.Mahasiswa;
import com.flashdin.belajarspringweb.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FakultasServiceImpl implements FakultasService {
    @Autowired
    private FakultasDAO fakultasDAO;

    @Override
    public Fakultas save(@RequestBody Fakultas param) {
        return fakultasDAO.save(param);
    }

    @Override
    public Fakultas update(@RequestBody Fakultas param) {
        return fakultasDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Fakultas param) {
        return fakultasDAO.delete(param);
    }

    @Override
    public Fakultas findById(@PathVariable int id) {
        return fakultasDAO.findById(id);
    }

    @Override
    public List<Fakultas> findAll() {
        return fakultasDAO.findAll();
    }

    @Override
    public List<Fakultas> find() {
        return fakultasDAO.find();
    }

    @Override
    public List<Fakultas> findByName(Fakultas param) {
        return fakultasDAO.findByName(param);
    }

}
