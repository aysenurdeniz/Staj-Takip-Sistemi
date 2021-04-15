/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ilan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class IlanDAO extends AbstractDAO{
    
    public void ekle(Ilan ilan) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into ilan (aciklama) values(?)");
            sql.setString(1, ilan.getAciklama());
            
            
           
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Ilan ilan) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from ilan where id=?");
            sql.setInt(1, ilan.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Ilan ilan) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update ilan set aciklama=? where id=?");
            sql.setString(1, ilan.getAciklama());
            
            
            sql.setInt(2,ilan.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Ilan> listele() {
        List<Ilan> ilanList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from ilan ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
             Ilan ilan=new Ilan();
                
                    ilan.setId(rs.getInt("id"));
                    ilan.setAciklama(rs.getString("aciklama"));
                    ilan.setIlan_tarih(rs.getString("ilan_tarih"));
                  

                ilanList.add(ilan);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return ilanList;
    }
    
}
