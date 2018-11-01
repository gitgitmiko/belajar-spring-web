package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Jurusan;

import java.util.List;

public interface JurusanService extends BaseService<Jurusan>{
    List<Jurusan> findByName(Jurusan param);
}

