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
public class Resepsionis {
    private int id_resepsionis;
    private String nama_resepsionis,username,password,level;

    public Resepsionis() {
    }

    public Resepsionis(int id_resepsionis, String nama_resepsionis) {
        this.id_resepsionis = id_resepsionis;
        this.nama_resepsionis = nama_resepsionis;
    }

    public int getId_resepsionis() {
        return id_resepsionis;
    }

    public void setId_resepsionis(int id_resepsionis) {
        this.id_resepsionis = id_resepsionis;
    }

    public String getNama_resepsionis() {
        return nama_resepsionis;
    }

    public void setNama_resepsionis(String nama_resepsionis) {
        this.nama_resepsionis = nama_resepsionis;
    }

    @Override
    public String toString() {
        return "Resepsionis{" + "id_resepsionis=" + id_resepsionis + ", nama_resepsionis=" + nama_resepsionis + '}';
    }
    
    
            
    
}
