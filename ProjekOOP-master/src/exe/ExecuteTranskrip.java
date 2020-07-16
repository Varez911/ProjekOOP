/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import db.ConnectionManager;
import com.*;
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
public class ExecuteTranskrip {
    ExecuteKamar exeKamar = new ExecuteKamar();
    ExecuteResepsionis exeResep = new ExecuteResepsionis();
    ExecutePasien exePasien = new ExecutePasien();
    ExecuteRiwayat exeRiwayat = new ExecuteRiwayat();
    public List<Transkrip> getTranskrip(){
        List<Transkrip> listTranskrip = new ArrayList<>();
        String query = "select * from transkip";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();        
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Transkrip _transkrip = new Transkrip();
                _transkrip.setId_transkrip(rs.getInt("id_transkip"));
                _transkrip.setNo_inap(rs.getString("no_inap"));
                _transkrip.setTgl_inap(rs.getDate("tgl_inap"));
                
                Kamar _newKamar = exeKamar.trackKamar(rs.getInt("id_kamar"));
                _transkrip.setKamar(_newKamar);
                Resepsionis _newResep = exeResep.trackResepsionis(rs.getInt("id_resepsionis"));
                _transkrip.setResepsionis(_newResep);
                Pasien _newPasien = exePasien.trackPasien(rs.getInt("id_pasien"));
                _transkrip.setPasien(_newPasien);
                Riwayat _newRiwayat = exeRiwayat.trackRiwayat(rs.getInt("id_riwayat"));
                _transkrip.setRiwayat(_newRiwayat);                
                
                listTranskrip.add(_transkrip);
            }
        }catch (SQLException ex) {
            Logger.getLogger(ExecuteTranskrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listTranskrip;        
    }
    
    public int insertTranskrip(Transkrip _transkrip){
        int Hasil = 0;
        String query = "insert into transkip(no_inap, tgl_inap, id_pasien,"
                +" id_resepsionis, id_riwayat, id_kamar)"
                +" values('"+_transkrip.getNo_inap()
                +"', '"+_transkrip.getTgl_inap()
                +"', '"+_transkrip.getPasien().getId_pasien()
                +"', '"+_transkrip.getResepsionis().getId_resepsionis()
                +"', '"+_transkrip.getRiwayat().getId_riwayat()
                +"', '"+_transkrip.getKamar().getId_kamar()+"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTranskrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int updateTranskrip(Transkrip _transkrip){
        int Hasil = 0;
        String query = "update transkip set "
                +"no_inap='"+_transkrip.getNo_inap()
                +"', tgl_inap='"+_transkrip.getTgl_inap()
                +"', id_pasien='"+_transkrip.getPasien().getId_pasien()
                +"', id_resepsionis='"+_transkrip.getResepsionis().getId_resepsionis()
                +"', id_riwayat='"+_transkrip.getRiwayat().getId_riwayat()
                +"', id_kamar='"+_transkrip.getKamar().getId_kamar()
                +"' where id_transkrip='"+_transkrip.getId_transkrip()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTranskrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public int deleteTranskrip(Transkrip _transkrip){
        int Hasil = 0;
        String query = "delete from transkip where id_transkip='"
                + _transkrip.getId_transkrip()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            Hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTranskrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return Hasil;
    }
    
    public Transkrip trackTranskrip(int id){
        Transkrip tracked = new Transkrip();
        String query = "select * from transkip where id_transkip='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                tracked.setId_transkrip(rs.getInt("id_transkrip"));
                tracked.setNo_inap(rs.getString("no_inap"));
                tracked.setTgl_inap(rs.getDate("tgl_inap"));
                
                Kamar _newKamar = exeKamar.trackKamar(rs.getInt("id_kamar"));
                tracked.setKamar(_newKamar);
                Resepsionis _newResep = exeResep.trackResepsionis(rs.getInt("id_resepsionis"));
                tracked.setResepsionis(_newResep);
                Pasien _newPasien = exePasien.trackPasien(rs.getInt("id_pasien"));
                tracked.setPasien(_newPasien);
                Riwayat _newRiwayat = exeRiwayat.trackRiwayat(rs.getInt("id_riwayat"));
                tracked.setRiwayat(_newRiwayat);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTranskrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return tracked;
    }
    
    public Object[][] listTranskrip(){
        ExecuteTranskrip exeTrans = new ExecuteTranskrip();
        List<Transkrip> listTranskrip = exeTrans.getTranskrip();
        Object[][] dataTranskrip = new Object[listTranskrip.size()][8];
        int mySize = 0;
        for (Transkrip transkrip: listTranskrip){
            dataTranskrip[mySize][0] = transkrip.getId_transkrip();
            dataTranskrip[mySize][1] = transkrip.getNo_inap();
            dataTranskrip[mySize][2] = transkrip.getTgl_inap();
            dataTranskrip[mySize][3] = transkrip.getResepsionis().getNama_resepsionis();
            dataTranskrip[mySize][4] = transkrip.getPasien().getNama_pasien();
            dataTranskrip[mySize][5] = transkrip.getRiwayat().getNama_penyakit();
            dataTranskrip[mySize][6] = transkrip.getRiwayat().getJenis_penyakit();
            dataTranskrip[mySize][7] = transkrip.getKamar().getId_kamar();
            mySize++;
        }
        return dataTranskrip;
    }
    
    public Object[][] listAdminTranskrip(){
        ExecuteTranskrip exeTrans = new ExecuteTranskrip();
        List<Transkrip> listTranskrip = exeTrans.getTranskrip();
        Object[][] dataTranskrip = new Object[listTranskrip.size()][7];
        int mySize = 0;
        for (Transkrip transkrip: listTranskrip){
            dataTranskrip[mySize][0] = transkrip.getId_transkrip();
            dataTranskrip[mySize][1] = transkrip.getNo_inap();
            dataTranskrip[mySize][2] = transkrip.getTgl_inap();
            dataTranskrip[mySize][3] = transkrip.getResepsionis().getId_resepsionis();
            dataTranskrip[mySize][4] = transkrip.getPasien().getId_pasien();
            dataTranskrip[mySize][5] = transkrip.getRiwayat().getId_riwayat();
            dataTranskrip[mySize][6] = transkrip.getKamar().getId_kamar();
            mySize++;
        }
        return dataTranskrip;
    }
}
