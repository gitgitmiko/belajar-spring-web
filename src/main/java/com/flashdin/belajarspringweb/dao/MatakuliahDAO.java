package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Matakuliah;

import java.util.List;
public interface MatakuliahDAO extends BaseDAO<Matakuliah>{

    List<Matakuliah> findByName(Matakuliah param);
}
