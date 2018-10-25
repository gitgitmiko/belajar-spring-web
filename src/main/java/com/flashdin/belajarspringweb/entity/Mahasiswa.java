package com.flashdin.belajarspringweb.entity;

public class Mahasiswa extends User {

    private String namaMhs;
    private String alamat;

    public Mahasiswa() {
    }

    public Mahasiswa(String namaMhs, String alamat) {
        this.namaMhs = namaMhs;
        this.alamat = alamat;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
