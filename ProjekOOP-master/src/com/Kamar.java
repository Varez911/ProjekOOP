/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author userPC
 */
public class Kamar {
    private int id_kamar, harga_kamar;
    private String tipe_kamar, status_kamar;

    public Kamar() {
    }

    public Kamar(int id_kamar, int harga_kamar, String tipe_kamar, String status_kamar) {
        this.id_kamar = id_kamar;
        this.harga_kamar = harga_kamar;
        this.tipe_kamar = tipe_kamar;
        this.status_kamar = status_kamar;
    }

    public int getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(int id_kamar) {
        this.id_kamar = id_kamar;
    }

    public int getHarga_kamar() {
        return harga_kamar;
    }

    public void setHarga_kamar(int harga_kamar) {
        this.harga_kamar = harga_kamar;
    }

    public String getTipe_kamar() {
        return tipe_kamar;
    }

    public void setTipe_kamar(String tipe_kamar) {
        this.tipe_kamar = tipe_kamar;
    }

    public String getStatus_kamar() {
        return status_kamar;
    }

    public void setStatus_kamar(String status_kamar) {
        this.status_kamar = status_kamar;
    }

    @Override
    public String toString() {
        return "Kamar{" + "id_kamar=" + id_kamar + ", harga_kamar=" + harga_kamar + ", tipe_kamar=" + tipe_kamar + ", status_kamar=" + status_kamar + '}';
    }
    
    
}
