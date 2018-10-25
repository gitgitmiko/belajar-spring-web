package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.MatakuliahDAO;
import com.flashdin.belajarspringweb.entity.Matakuliah;
import com.flashdin.belajarspringweb.service.MatakuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class MatakuliahServiceImpl implements MatakuliahService {
    @Autowired
    private MatakuliahDAO matakuliahDAO;

    @Override
    public Matakuliah save(@RequestBody Matakuliah param) {
        return matakuliahDAO.save(param);
    }

    @Override
    public Matakuliah update(@RequestBody Matakuliah param) {
        return matakuliahDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Matakuliah param) {
        return matakuliahDAO.delete(param);
    }

    @Override
    public Matakuliah findById(@PathVariable int id) {
        return matakuliahDAO.findById(id);
    }

    @Override
    public List<Matakuliah> findAll() {
        return matakuliahDAO.findAll();
    }

    @Override
    public List<Matakuliah> findByName(Matakuliah param) {
        return matakuliahDAO.findByName(param);
    }

}
