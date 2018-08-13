package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Profile;

import java.util.List;

public interface ProfileSevice extends BaseService<Profile> {

    List<Profile> findByName(Profile param);
    
}
