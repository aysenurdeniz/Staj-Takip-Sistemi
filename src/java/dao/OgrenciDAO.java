/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ogrenci;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.jboss.logging.Logger;
import util.DBConnection;

/**
 *
 * @author hp
 */
public class OgrenciDAO extends AbstractDAO{
    
   

     public void ekle(Ogrenci ogrenci) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into ogrenci (ad_soyad,cep_numara,e_mail) values(?,?,?)");
            sql.setString(1, ogrenci.getAd_soyad());
            sql.setString(2, ogrenci.getCep_numara());
            sql.setString(3, ogrenci.getE_mail());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Ogrenci ogrenci) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from ogrenci where id=?");
            sql.setInt(1, ogrenci.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Ogrenci ogrenci) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update ogrenci set ad_soyad=? ,cep_numara=?,e_mail=? where id=?");
            sql.setString(1, ogrenci.getAd_soyad());
            sql.setString(2, ogrenci.getCep_numara());
            sql.setString(3, ogrenci.getE_mail());
            sql.setInt(4, ogrenci.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Ogrenci> listele() {
        List<Ogrenci> ogrenciList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from ogrenci ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Ogrenci ogrenci=new Ogrenci();
                
                    ogrenci.setId(rs.getInt("id"));
                    ogrenci.setAd_soyad(rs.getString("ad_soyad"));
                    ogrenci.setCep_numara(rs.getString("cep_numara"));
                    ogrenci.setE_mail(rs.getString("e_mail"));
                    
                    rs.getInt("id");
                ogrenciList.add(ogrenci);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return ogrenciList;
    }

   
    
}
