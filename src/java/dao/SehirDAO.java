/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Sehir;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SehirDAO extends AbstractDAO {
     public void ekle(Sehir sehir) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into kurum (sehir_adi) values(?)");
            sql.setString(1, sehir.getSehir_adi());
     
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Sehir sehir) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from sehir where id=?");
            sql.setInt(1, sehir.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Sehir sehir) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update sehir set sehir_adi=?  where id=?");
            sql.setString(1, sehir.getSehir_adi());
           
            sql.setInt(2, sehir.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Sehir> listele() {
        List<Sehir> sehirList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from sehir ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Sehir sehir=new Sehir();
                
                    sehir.setId(rs.getInt("id"));
                    sehir.setSehir_adi(rs.getString("sehir_adi"));
                  
               

                sehirList.add(sehir);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return sehirList;
    }


    
}
