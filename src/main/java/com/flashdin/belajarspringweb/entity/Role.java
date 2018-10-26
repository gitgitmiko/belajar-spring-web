package com.flashdin.belajarspringweb.entity;

import javax.persistence.ManyToMany;
import java.util.Set;

public class Role extends User {

    private String name;
    private Set<User> users;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUser() {
        return users;
    }

    public void setUser(Set<User> users) {
        this.users = users;
    }
}

