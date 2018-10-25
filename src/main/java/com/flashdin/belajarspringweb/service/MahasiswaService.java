package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Mahasiswa;


import java.util.List;
public interface MahasiswaService extends BaseService<Mahasiswa>{
    List<Mahasiswa> findByName(Mahasiswa param);
}

