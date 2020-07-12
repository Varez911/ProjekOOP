/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import com.Pasien;
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
public class ExecutePasien {
    public List<Pasien> getPasien(){
        List<Pasien> listPasien = new ArrayList<>();
        String query = "select * from pasien";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Pasien _pasien = new Pasien();
                _pasien.setId_pasien(rs.getInt("id_kamar"));
                _pasien.setNama_pasien(rs.getString("biaya_kamar"));
                _pasien.setTgl_pasien(rs.getDate("status_kamar"));
                listPasien.add(_pasien);
            }
        }catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listPasien;        
    }
    
    public int insertPasien(Pasien _pasien){
        int Hasil = 0;
        String query = "insert into pasien(nama_pasien, tgl_pasien)"
                +" values('"+_pasien.getNama_pasien()
                +"','"+_pasien.getTgl_pasien()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int updatePasien(Pasien _pasien){
        int Hasil = 0;
        String query = "update pasien set"
                +" nama_pasien='" + _pasien.getNama_pasien()
                +"', tgl_pasien='" + _pasien.getTgl_pasien()+"'"
                +" where id_pasien='"+_pasien.getId_pasien()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int deletePasien(Pasien _pasien){
        int Hasil = 0;
        String query = "delete from pasien where id_pasien='"
                + _pasien.getId_pasien()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public Pasien trackPasien(int id){
        Pasien tracked = new Pasien();
        String query = "select * from pasien where id_pasien='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                tracked.setId_pasien(rs.getInt("id_pasien"));
                tracked.setNama_pasien(rs.getString("nama_pasien"));
                tracked.setTgl_pasien(rs.getDate("tgl_pasien"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return tracked;
    }
    
    public Object[][] listKamar(){
        ExecutePasien exeP = new ExecutePasien();
        List<Pasien> listPasien = exeP.getPasien();
        Object[][] dataPasien = new Object[listPasien.size()][3];
        int mySize = 0;
        for (Pasien pasien: listPasien){
            dataPasien[mySize][0] = pasien.getId_pasien();
            dataPasien[mySize][1] = pasien.getNama_pasien();
            dataPasien[mySize][2] = pasien.getTgl_pasien();
            mySize++;
        }
        return dataPasien;
    }
}
