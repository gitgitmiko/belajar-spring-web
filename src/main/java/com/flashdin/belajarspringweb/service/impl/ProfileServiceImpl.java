package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.ProfileDAO;
import com.flashdin.belajarspringweb.dao.impl.ProfileDAOImpl;
import com.flashdin.belajarspringweb.entity.Profile;
import com.flashdin.belajarspringweb.service.ProfileSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileSevice {

    @Autowired
    private ProfileDAO profileDAO;

    @Override
    public Profile save(@RequestBody Profile param) {
        return profileDAO.save(param);
    }

    @Override
    public Profile update(@RequestBody Profile param) {
        return profileDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Profile param) {
        return profileDAO.delete(param);
    }

    @Override
    public Profile findById(@PathVariable int id) {
        return profileDAO.findById(id);
    }

    @Override
    public List<Profile> findAll() {
        return profileDAO.findAll();
    }

    @Override
    public List<Profile> find() {
        return profileDAO.find();
    }

    @Override
    public List<Profile> findByName(Profile param) {
        return profileDAO.findByName(param);
    }
}
