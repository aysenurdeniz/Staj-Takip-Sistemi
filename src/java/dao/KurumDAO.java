/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kurum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class KurumDAO extends AbstractDAO {
     
   private SektorDAO sektorDao;
    
    public void ekle(Kurum kurum) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into kurum (kurum_adi,kurum_adresi) values(?,?)");
            sql.setString(1, kurum.getKurum_adi());
            sql.setString(2, kurum.getKurum_adresi());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Kurum kurum) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from kurum where id=?");
            sql.setInt(1, kurum.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Kurum kurum) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update kurum set kurum_adi=? ,kurum_adresi=? where id=?");
            sql.setString(1, kurum.getKurum_adi());
            sql.setString(2, kurum.getKurum_adresi());
            sql.setInt(3, kurum.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Kurum> listele() {
        List<Kurum> kurumList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from kurum ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Kurum kurum=new Kurum();
                
                    kurum.setId(rs.getInt("id"));
                    kurum.setKurum_adi(rs.getString("kurum_adi"));
                    kurum.setKurum_adresi(rs.getString("kurum_adresi"));
                    kurum.setKurum_Sektor(this.getSektorDao().getKurumsektor(kurum.getId()));

                kurumList.add(kurum);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return kurumList;
    }

    
    public Kurum find(int id){
        Kurum kur= null;
        try{
             PreparedStatement sql = this.getConnection()
                     .prepareStatement("select *from kurum where id=?");
                     sql.setInt(1, id);
                    ResultSet rs = sql.executeQuery();
                    rs.next();
                    kur= new Kurum();
                    
                    kur.setId(rs.getInt("id"));
                    kur.setKurum_adi(rs.getString("kurum_adi"));
                    kur.setKurum_adresi(rs.getString("kurum_adresi"));
                    kur.setKurum_Sektor(this.getSektorDao().getKurumsektor(id));
            
        }catch(SQLException ex){
            System.out.println("DAO Hata:" + ex.getMessage());
        }
        return kur;
    }
    public SektorDAO getSektorDao() {
        
        if(this.sektorDao==null )
            this.sektorDao= new SektorDAO();
        return sektorDao;
    }

   
}
