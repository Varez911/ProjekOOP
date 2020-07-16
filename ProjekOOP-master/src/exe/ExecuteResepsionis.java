/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import com.Resepsionis;
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
public class ExecuteResepsionis {
    public List<Resepsionis> getResepsionis(){
        List<Resepsionis> listPasien = new ArrayList<>();
        String query = "select * from resepsionis";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Resepsionis _resep = new Resepsionis();
                _resep.setId_resepsionis(rs.getInt("id_resepsionis"));
                _resep.setNama_resepsionis(rs.getString("nama_resepsionis"));
                _resep.setUsername(rs.getString("username"));
                _resep.setPassword(rs.getString("password"));
                _resep.setLevel(rs.getString("level"));
                listPasien.add(_resep);
            }
        }catch (SQLException ex) {
            Logger.getLogger(ExecuteResepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listPasien;        
    }
    
    public int insertResepsionis(Resepsionis _resep){
        int Hasil = 0;
        String query = "insert into resepsionis(nama_resepsionis, username, password, level)"
                +" values('"+_resep.getNama_resepsionis()
                +"','"+_resep.getUsername()
                +"','"+_resep.getPassword()
                +"','"+_resep.getLevel()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteResepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int updateResepsionis(Resepsionis _resep){
        int Hasil = 0;
        String query = "update resepsionis set"
                +" nama_resepsionis='" + _resep.getNama_resepsionis()
                +"', username='"+_resep.getUsername()
                +"', password='"+_resep.getPassword()
                +"', level='"+_resep.getLevel()
                +"' where id_resepsionis='"+_resep.getId_resepsionis()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteResepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int deleteResepsionis(Resepsionis _resep){
        int Hasil = 0;
        String query = "delete from resepsionis where id_resepsionis='"
                + _resep.getId_resepsionis()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteResepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int deleteResepsionis(int _resep){
        int Hasil = 0;
        String query = "delete from resepsionis where id_resepsionis='"
                + _resep+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteResepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public Resepsionis trackResepsionis(int id){
        Resepsionis tracked = new Resepsionis();
        String query = "select * from resepsionis where id_resepsionis='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                tracked.setId_resepsionis(rs.getInt("id_resepsionis"));
                tracked.setNama_resepsionis(rs.getString("nama_resepsionis"));
                tracked.setUsername(rs.getString("username"));
                tracked.setPassword(rs.getString("password"));
                tracked.setLevel(rs.getString("level"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteResepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return tracked;
    }
    
    public Object[][] listResepsionis(){
        ExecuteResepsionis exeR = new ExecuteResepsionis();
        List<Resepsionis> listResepsionis = exeR.getResepsionis();
        Object[][] dataResepsionis = new Object[listResepsionis.size()][5];
        int mySize = 0;
        for (Resepsionis resep: listResepsionis){
            dataResepsionis[mySize][0] = resep.getId_resepsionis();
            dataResepsionis[mySize][1] = resep.getNama_resepsionis();
            dataResepsionis[mySize][2] = resep.getUsername();
            dataResepsionis[mySize][3] = resep.getPassword();
            dataResepsionis[mySize][4] = resep.getLevel();
            mySize++;
        }
        return dataResepsionis;
    }
}
