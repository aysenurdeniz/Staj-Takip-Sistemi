/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bolum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class BolumDAO extends AbstractDAO {
    
    
  
    public void ekle(Bolum bolum) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into bolum (bolum_adi) values(?)");
            sql.setString(1, bolum.getBolum_adi());
            
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Bolum bolum) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from bolum where id=?");
            sql.setInt(1, bolum.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Bolum bolum) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update bolum set bolum_adi=?  where id=?");
            sql.setString(1, bolum.getBolum_adi());
            
            sql.setInt(2, bolum.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Bolum> listele() {
        List<Bolum> bolumList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from bolum ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
               Bolum bolum=new Bolum();
                
                    bolum.setId(rs.getInt("id"));
                    bolum.setBolum_adi(rs.getString("bolum_adi"));
                   
               

                bolumList.add(bolum);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return bolumList;
    }


}
