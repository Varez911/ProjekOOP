/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import java.sql.Date;
/**
 *
 * @author userPC
 */
public class Riwayat {
    private int id_riwayat;
    private String nama_penyakit, jenis_penyakit;
    private Date waktu_penyakit;

    public Riwayat() {
    }

    public Riwayat(int id_riwayat, String nama_penyakit, String jenis_penyakit, Date waktu_penyakit) {
        this.id_riwayat = id_riwayat;
        this.nama_penyakit = nama_penyakit;
        this.jenis_penyakit = jenis_penyakit;
        this.waktu_penyakit = waktu_penyakit;
    }

    public int getId_riwayat() {
        return id_riwayat;
    }

    public void setId_riwayat(int id_riwayat) {
        this.id_riwayat = id_riwayat;
    }

    public String getNama_penyakit() {
        return nama_penyakit;
    }

    public void setNama_penyakit(String nama_penyakit) {
        this.nama_penyakit = nama_penyakit;
    }

    public String getJenis_penyakit() {
        return jenis_penyakit;
    }

    public void setJenis_penyakit(String jenis_penyakit) {
        this.jenis_penyakit = jenis_penyakit;
    }

    public Date getWaktu_penyakit() {
        return waktu_penyakit;
    }

    public void setWaktu_penyakit(Date waktu_penyakit) {
        this.waktu_penyakit = waktu_penyakit;
    }

    @Override
    public String toString() {
        return "Riwayat{" + "id_riwayat=" + id_riwayat + ", nama_penyakit=" + nama_penyakit + ", jenis_penyakit=" + jenis_penyakit + ", waktu_penyakit=" + waktu_penyakit + '}';
    }
    
    
}
