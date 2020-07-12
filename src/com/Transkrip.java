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
public class Transkrip {
    private int id_transkrip;
    private String no_inap;
    private Date tgl_inap;
    private Pasien _pasien;
    private Riwayat _riwayat;
    private Kamar _kamar;
    private Resepsionis _resepsionis;
    
    public Transkrip() {
        this._kamar = new Kamar();
    }

    public Transkrip(String no_inap, Date tgl_inap, Pasien _pasien, Riwayat _riwayat, Kamar _kamar, Resepsionis _resepsionis) {
        this.no_inap = no_inap;
        this.tgl_inap = tgl_inap;
        this._pasien = _pasien;
        this._riwayat = _riwayat;
        this._kamar = _kamar;
        this._resepsionis = _resepsionis;
    }

    public int getId_transkrip() {
        return id_transkrip;
    }

    public void setId_transkrip(int id_transkrip) {
        this.id_transkrip = id_transkrip;
    }

    public Resepsionis getResepsionis() {
        return _resepsionis;
    }

    public void setResepsionis(Resepsionis _resepsionis) {
        this._resepsionis = _resepsionis;
    }

    public Pasien getPasien() {
        return _pasien;
    }

    public void setPasien(Pasien _pasien) {
        this._pasien = _pasien;
    }

    public Riwayat getRiwayat() {
        return _riwayat;
    }

    public void setRiwayat(Riwayat _riwayat) {
        this._riwayat = _riwayat;
    }

    public Kamar getKamar() {
        return _kamar;
    }

    public void setKamar(Kamar _kamar) {
        this._kamar = _kamar;
    }

    public String getNo_inap() {
        return no_inap;
    }

    public void setNo_inap(String no_inap) {
        this.no_inap = no_inap;
    }

    public Date getTgl_inap() {
        return tgl_inap;
    }

    public void setTgl_inap(Date tgl_inap) {
        this.tgl_inap = tgl_inap;
    }
    
    
}
