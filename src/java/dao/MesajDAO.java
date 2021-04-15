/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Mesaj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class MesajDAO extends AbstractDAO {
    
     
    public void ekle(Mesaj mesaj) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into mesaj (ad_soyad,e_mail,cep_numarasi,baslik,konu) values(?,?,?,?,?)");
            sql.setString(1,mesaj.getAd_soyad());
            sql.setString(2, mesaj.getE_mail());
            sql.setString(3,mesaj.getCep_numarasi());
            sql.setString(4,mesaj.getBaslik());
            sql.setString(5,mesaj.getKonu());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Mesaj mesaj) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from mesaj where id=?");
            sql.setInt(1, mesaj.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Mesaj mesaj) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update mesaj set ad_soyad=? ,e_mail=?, cep_numarasi= ?, baslik=?, konu =? where id=?");
            sql.setString(1, mesaj.getAd_soyad());
            sql.setString(2, mesaj.getE_mail());
            sql.setString(3,mesaj.getCep_numarasi());
            sql.setString(4, mesaj.getBaslik());
            sql.setString(5, mesaj.getKonu());
            sql.setInt(6, mesaj.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Mesaj> listele() {
        List<Mesaj> mesajList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from mesaj ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Mesaj mesaj=new Mesaj();
                
                    mesaj.setId(rs.getInt("id"));
                    mesaj.setAd_soyad(rs.getString("ad_soyad"));
                    mesaj.setE_mail(rs.getString("e_mail"));
                    mesaj.setCep_numarasi("cep_numarasi");
                    mesaj.setBaslik("baslik");
                    mesaj.setKonu("konu");
               

                mesajList.add(mesaj);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return mesajList;
    }

    
}
