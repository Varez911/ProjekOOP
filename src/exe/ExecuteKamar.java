/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import db.ConnectionManager;
import com.Kamar;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author userPC
 */
public class ExecuteKamar {
    public List<Kamar> getKamar(){
        List<Kamar> listKamar = new ArrayList<>();
        String query = "select * from kamar";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Kamar _kamar = new Kamar();
                _kamar.setId_kamar(rs.getInt("id_kamar"));
                _kamar.setHarga_kamar(rs.getInt("biaya_kamar"));
                _kamar.setStatus_kamar(rs.getString("status_kamar"));
                _kamar.setTipe_kamar(rs.getString("tipe_kamar"));
                listKamar.add(_kamar);
            }
        }catch (SQLException ex) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listKamar;        
    }
    
    public int insertKamar(Kamar _kamar){
        int Hasil = 0;
        String query = "insert into kamar(biaya_kamar, status_kamar, tipe_kamar) "
                +"values('"+_kamar.getHarga_kamar()
                +"','"+_kamar.getStatus_kamar()
                +"','"+_kamar.getTipe_kamar()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int updateKamar(Kamar _kamar){
        int hasil = 0;
        String query = "update kamar set biaya_kamar = '"+_kamar.getHarga_kamar()
                +"', status_kamar='"+_kamar.getStatus_kamar()
                +"', tipe_kamar='"+_kamar.getTipe_kamar()
                +"' where id_kamar='"+_kamar.getId_kamar()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int deleteKamar(Kamar _kamar){
        int Hasil = 0;
        String query = "delete from kamar where id_kamar='"
                + _kamar.getId_kamar()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int StatusUpdate(String id, String Status){
        int Hasil = 0;
                String query = "update kamar set status_kamar='"+Status+"' where id_kamar='"
                + id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public Kamar trackKamar(String id){
        Kamar tracked = new Kamar();
        String query = "select * from kamar where id_kamar='"
                + id +"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                tracked.setId_kamar(rs.getInt("id_kamar"));
                tracked.setHarga_kamar(rs.getInt("biaya_kamar"));
                tracked.setStatus_kamar(rs.getString("status_kamar"));
                tracked.setTipe_kamar(rs.getString("tipe_kamar"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return tracked;
    }
    
    public Object[][] listKamar(){
        ExecuteKamar _kamar = new ExecuteKamar();
        List<Kamar> listKamar = _kamar.getKamar();
        Object[][] dataKamar = new Object[listKamar.size()][4];
        int mySize = 0;
        for (Kamar kamar: listKamar){
            dataKamar[mySize][0] = kamar.getId_kamar();
            dataKamar[mySize][1] = kamar.getTipe_kamar();
            dataKamar[mySize][2] = kamar.getStatus_kamar();
            dataKamar[mySize][3] = "Rp."+kamar.getHarga_kamar();
            mySize++;
        }
        return dataKamar;
    }
}
