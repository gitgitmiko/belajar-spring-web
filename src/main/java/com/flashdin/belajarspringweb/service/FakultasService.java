package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Fakultas;

import java.util.List;

public interface FakultasService extends BaseService<Fakultas>{
    List<Fakultas> findByName(Fakultas param);
}

