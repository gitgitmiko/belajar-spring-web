package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Profile;

import java.util.List;

public interface ProfileDAO extends BaseDAO<Profile> {

    List<Profile> findByName(Profile param);

}
