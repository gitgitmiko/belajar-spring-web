package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.JurusanDAO;
import com.flashdin.belajarspringweb.entity.Jurusan;
import com.flashdin.belajarspringweb.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JurusanServiceImpl implements JurusanService {
    @Autowired
    private JurusanDAO jurusanDAO;

    @Override
    public Jurusan save(@RequestBody Jurusan param) {
        return jurusanDAO.save(param);
    }

    @Override
    public Jurusan update(@RequestBody Jurusan param) {
        return jurusanDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Jurusan param) {
        return jurusanDAO.delete(param);
    }

    @Override
    public Jurusan findById(@PathVariable int id) {
        return jurusanDAO.findById(id);
    }

    @Override
    public List<Jurusan> findAll() {
        return jurusanDAO.findAll();
    }

    @Override
    public List<Jurusan> findByName(Jurusan param) {
        return jurusanDAO.findByName(param);
    }

}
