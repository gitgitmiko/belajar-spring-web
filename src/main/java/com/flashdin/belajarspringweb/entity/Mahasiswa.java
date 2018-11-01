package com.flashdin.belajarspringweb.entity;

import java.io.Serializable;

public class Mahasiswa extends User implements Serializable {

    private String namaMhs;
    private String alamat;
    private int idFakultas;
    private int idJurusan;

    private Jurusan jurusan;
    private Fakultas Fakultas;

    public Mahasiswa() {
    }

    public Mahasiswa(String namaMhs, String alamat, int idFakultas, int idFurusan) {
        this.namaMhs = namaMhs;
        this.alamat = alamat;
        this.idFakultas = idFakultas;
        this.idJurusan = idJurusan;

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Fakultas getFakultas() {
        return Fakultas;
    }
    public void setFakultas(Fakultas fakultas) {
        this.Fakultas = fakultas;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }
    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
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

    public int getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(int idFakultas) {
        this.idFakultas = idFakultas;
    }

    public int getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(int idJurusan) {
        this.idJurusan = idJurusan;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id = " + id +
                ", namaMhs='" + namaMhs + '\'' +
                ", alamat='" + alamat + '\'' +
                ", idfakultas='" + idFakultas +
                "idmakul=" + idJurusan +

                '}';
    }



}
