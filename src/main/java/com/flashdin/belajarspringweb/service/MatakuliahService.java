package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Matakuliah;


import java.util.List;
public interface MatakuliahService extends BaseService<Matakuliah>{
    List<Matakuliah> findByName(Matakuliah param);
}

