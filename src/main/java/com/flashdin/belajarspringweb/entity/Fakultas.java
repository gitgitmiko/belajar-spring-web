package com.flashdin.belajarspringweb.entity;

public class Fakultas extends User {

    private String nama;
    private int idFakultas;

    public Fakultas() {
    }

    public Fakultas(String nama, int idFakultas) {
        this.nama = nama;
        this.idFakultas = idFakultas;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(int idFakultas) {
        this.idFakultas = idFakultas;
    }

    @Override
    public String toString() {
        return "Fakultas{" +
                "id = " + id +
                ", nama='" + nama + '\'' +
                '}';
    }

}
