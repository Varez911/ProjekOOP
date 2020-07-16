/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import com.Riwayat;
import com.mysql.jdbc.Connection;
import db.ConnectionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author userPC
 */
public class ExecuteRiwayat {
    public List<Riwayat> getRiwayat(){
        List<Riwayat> listRiwayat = new ArrayList<>();
        String query = "select * from riwayat_penyakit";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Riwayat _riwayat = new Riwayat();
                _riwayat.setId_riwayat(rs.getInt("id_riwayat"));
                _riwayat.setNama_penyakit(rs.getString("nama_resepsionis"));
                _riwayat.setJenis_penyakit(rs.getString("jenis_riwayat"));
                _riwayat.setWaktu_penyakit(rs.getDate("waktu_riwayat"));
                listRiwayat.add(_riwayat);
            }
        }catch (SQLException ex) {
            Logger.getLogger(ExecuteRiwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listRiwayat;        
    }
    
    public int insertRiwayat(Riwayat _riwayat){
        int Hasil = 0;
        String query = "insert into riwayat_penyakit(nama_penyakit, jenis_penyakit, waktu_penyakit)"
                +" values('"+_riwayat.getNama_penyakit()
                +"', '"+ _riwayat.getJenis_penyakit()
                +"', '"+_riwayat.getWaktu_penyakit()
                +"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRiwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int updateRiwayat(Riwayat _riwayat){
        int Hasil = 0;
        String query = "update riwayat_penyakit set"
                +" nama_penyakit='" + _riwayat.getNama_penyakit()
                +"' jenis_penyakit='" + _riwayat.getJenis_penyakit()
                +"' waktu_penyakit='" + _riwayat.getWaktu_penyakit()
                +"' where id_riwayat='"+_riwayat.getId_riwayat()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRiwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int deleteRiwayat(Riwayat _resep){
        int Hasil = 0;
        String query = "delete from riwayat_penyakit where id_riwayat='"
                + _resep.getId_riwayat()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRiwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public Riwayat trackRiwayat(int id){
        Riwayat tracked = new Riwayat();
        String query = "select * from riwayat_penyakit where id_riwayat='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                tracked.setId_riwayat(rs.getInt("id_riwayat"));
                tracked.setNama_penyakit(rs.getString("nama_penyakit"));
                tracked.setJenis_penyakit(rs.getString("jenis_penyakit"));
                tracked.setWaktu_penyakit(rs.getDate("waktu_penyakit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteRiwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return tracked;
    }
    
    public Object[][] listRiwayat(){
        ExecuteRiwayat exeRP = new ExecuteRiwayat();
        List<Riwayat> listRiwayat = exeRP.getRiwayat();
        Object[][] dataRiwayat = new Object[listRiwayat.size()][4];
        int mySize = 0;
        for (Riwayat riwayat: listRiwayat){
            dataRiwayat[mySize][0] = riwayat.getId_riwayat();
            dataRiwayat[mySize][1] = riwayat.getNama_penyakit();
            dataRiwayat[mySize][2] = riwayat.getJenis_penyakit();
            dataRiwayat[mySize][3] = riwayat.getWaktu_penyakit();
            mySize++;
        }
        return dataRiwayat;
    }
}
