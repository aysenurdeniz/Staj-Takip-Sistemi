/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Sektor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class SektorDAO extends AbstractDAO {
    private KurumDAO kurDao;
    
     public void ekle(Sektor sektor) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into sektor (sektor_adi) values(?)");
            sql.setString(1, sektor.getSektor_adi());
            
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Sektor sektor) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from sektor where id=?");
            sql.setInt(1, sektor.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Sektor sektor) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update sektor set sektor_adi=?  where id=?");
            sql.setString(1, sektor.getSektor_adi());
           
            sql.setInt(2, sektor.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Sektor> listele() {
        List<Sektor> sektorList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from sektor ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Sektor sektor=new Sektor();
                
                    sektor.setId(rs.getInt("id"));
                    sektor.setSektor_adi(rs.getString("sektor_adi"));
            
               

                sektorList.add(sektor);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return sektorList;
    }
    
    public Sektor find(int id){
        Sektor s = null;
        
        try{
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from sektor where id=?");
            
            
            ResultSet rs = sql.executeQuery();
            
            s= new Sektor();
            s.setId(rs.getInt("id"));
            s.setSektor_adi("sektor_adi");
            
            
        }catch(SQLException ex){
             System.out.println("DAO Hata:" + ex.getMessage());
        }
        return s;
    }
    
    
    public List<Sektor> getKurumsektor(int id) {
        List <Sektor> kurumSektor = new ArrayList<>();
        
        try{
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from kurum_sektor where ks_id=?");
                     sql.setInt(1, id);
                     ResultSet rs = sql.executeQuery();
                     
                     while (rs.next()){
                         kurumSektor.add(this.find(rs.getInt("id")));
                     }
        }catch(SQLException ex){
            System.out.println("DAO Hata:" + ex.getMessage());
            
        }
        
        return kurumSektor;
    }

    public KurumDAO getKurDao() {
        return kurDao;
    }

   


    
}
