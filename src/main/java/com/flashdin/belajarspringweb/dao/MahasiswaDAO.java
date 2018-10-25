package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Mahasiswa;

import java.util.List;
public interface MahasiswaDAO extends BaseDAO<Mahasiswa>{

    List<Mahasiswa> findByName(Mahasiswa param);
}
