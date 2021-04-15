/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Dosya;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class DosyaDAO extends AbstractDAO {
     
    public void ekle(Dosya dosya) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into dosya (dosya_adi,dosya_boyutu,dosya_yolu,dosya_tipi) values(?,?,?,?)");
            sql.setString(1, dosya.getDosya_adi());
            sql.setString(2, dosya.getDosya_boyutu());
            sql.setString(3, dosya.getDosya_yolu());
            sql.setString(4, dosya.getDosya_tipi());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Dosya dosya) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from dosya where id=?");
            sql.setInt(1, dosya.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Dosya dosya) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update dosya set dosya_adi=? ,=? where id=?");
            sql.setString(1, dosya.getDosya_adi());
            sql.setString(2, dosya.getDosya_boyutu());
            sql.setString(3, dosya.getDosya_yolu());
            sql.setString(4, dosya.getDosya_boyutu());
            sql.setInt(5, dosya.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Dosya> listele() {
        List<Dosya> dosyaList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from dosya ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
               Dosya dosya=new Dosya();
                
                   dosya.setId(rs.getInt("id"));
                   dosya.setDosya_adi(rs.getString("dosya_adi"));
                   dosya.setDosya_boyutu(rs.getString("dosya_boyutu"));
                   dosya.setDosya_yolu(rs.getString("dosya_yolu"));
                   dosya.setDosya_tipi(rs.getString("dosya_tipi"));
               

                dosyaList.add(dosya);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return dosyaList;
    }

    
}
