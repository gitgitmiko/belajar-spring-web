package com.flashdin.belajarspringweb.entity;

public class Matakuliah extends User {

    private String makul;

    public Matakuliah() {
    }

    public Matakuliah(String makul) {
        this.makul = makul;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }


}
