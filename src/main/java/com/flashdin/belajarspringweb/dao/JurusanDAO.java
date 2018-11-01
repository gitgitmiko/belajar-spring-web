package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Jurusan;

import java.util.List;

public interface JurusanDAO extends BaseDAO<Jurusan>{

    List<Jurusan> findByName(Jurusan param);
}
