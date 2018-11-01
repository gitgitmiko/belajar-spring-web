package com.flashdin.belajarspringweb.entity;

public class Jurusan extends User {

    private String nama;
    private int idFakultas, idJurusan;
    private Fakultas fakultas;//object join
    public Jurusan() {
    }

    public Jurusan(String nama, int idJurusan, int idFakultas) {
        this.nama = nama;
        this.idJurusan = idJurusan;
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

    public int getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(int idFakultas) {
        this.idFakultas = idFakultas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(int idJurusan) {
        this.idJurusan = idJurusan;
    }

    //join
    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }
    //

    @Override
    public String toString() {
        return "Jurusan{" +
                "id = " + id +
                ", nama='" + nama + '\'' +
                ", idFakultas='" + idFakultas +
                '}';
    }

}
