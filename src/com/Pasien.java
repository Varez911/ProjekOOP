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
public class Pasien {
    private int id_pasien;
    private String nama_pasien;
    private Date tgl_pasien;

    public Pasien() {
    }

    public Pasien(int id_pasien, String nama_pasien, Date tgl_pasien) {
        this.id_pasien = id_pasien;
        this.nama_pasien = nama_pasien;
        this.tgl_pasien = tgl_pasien;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public Date getTgl_pasien() {
        return tgl_pasien;
    }

    public void setTgl_pasien(Date tgl_pasien) {
        this.tgl_pasien = tgl_pasien;
    }

    @Override
    public String toString() {
        return "Pasien{" + "id_pasien=" + id_pasien + ", nama_pasien=" + nama_pasien + ", tgl_pasien=" + tgl_pasien + '}';
    }
    
    
}
