/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Universite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class UniversiteDAO extends AbstractDAO {
    private OgrenciDAO ogrDao;
    
      public void ekle(Universite universite) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into universite (universite_adi) values(?)");
            sql.setString(1, universite.getUniversite_adi());
            
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Universite universite) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from universite where id=?");
            sql.setInt(1, universite.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Universite universite) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update bolum set universite_adi=?  where id=?");
            sql.setString(1, universite.getUniversite_adi());
            
            sql.setInt(2, universite.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Universite> listele() {
        List<Universite> universiteList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from universite ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
               Universite universite=new Universite();
                
                    universite.setId(rs.getInt("id"));
                  universite.setUniversite_adi(rs.getString("universite_adi"));
                   
               

               universiteList.add(universite);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return universiteList;
    }

    public Universite find(int id){
        Universite uni = null;
        try{
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from universite where id=?");
            
                    ResultSet rs = sql.executeQuery();
                    
                    rs.next();
                    
                    uni = new Universite();
                    uni.setId(rs.getInt("id"));
                    uni.setUniversite_adi(rs.getString("universite_adi"));
                    
        }catch(SQLException ex){
          System.out.println("DAO Hata:" + ex.getMessage());  
        }
        return uni;
    }
}
