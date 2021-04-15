package dao;

import entity.Kullanici;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KullaniciDAO extends AbstractDAO {
    
    private YetkiDAO yetDao;

    public void ekle(Kullanici kul) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into kullanici (ad_soyad,kullanici_adi,kullanici_sifresi,kullanici_mail,kullanici_cep) values(?,?,?,?,?)");
            sql.setString(1, kul.getAd_soyad());
            sql.setString(2, kul.getKullanici_adi());
            sql.setString(3, kul.getKullanici_sifresi());
            sql.setString(4, kul.getKullanici_mail());
            sql.setString(5, kul.getKullanici_cep());
           // sql.setString(6, kul.getKayit_tarih());

            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Kullanici kul) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from kullanici where id=?");
            sql.setInt(1, kul.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Kullanici kul) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update kullanici set ad_soyad=?,kullanici_adi=?,kullanici_sifresi=?,kullanici_mail=?,kullanici_cep=? where id=?");
            sql.setString(1, kul.getAd_soyad());
            sql.setString(2, kul.getKullanici_adi());
            sql.setString(3, kul.getKullanici_sifresi());
            sql.setString(4, kul.getKullanici_mail());
            sql.setString(5, kul.getKullanici_cep());
            sql.setString(6, kul.getKayit_tarih());
            sql.setInt(7, kul.getId());
            sql.executeUpdate();
            sql.close();
            
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Kullanici> listele() {
        List<Kullanici> kullaniciList = new ArrayList();

        try {
           
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from kullanici ");

            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Kullanici kul = new Kullanici();
                kul.setAd_soyad(rs.getString("ad_soyad"));
                kul.setKullanici_adi(rs.getString("kullanici_adi"));          
                kul.setKullanici_sifresi(rs.getString("kullanici_sifresi"));
                kul.setKullanici_mail(rs.getString("kullanici_mail"));
                kul.setId(rs.getInt("id"));
                kul.setKullanici_cep(rs.getString("kullanici_cep"));
                kul.setKayit_tarih(rs.getString("kayit_tarih"));

                kullaniciList.add(kul);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return kullaniciList;
    }

    
    public Kullanici find(int id){
        Kullanici kul = null;
        
        try{
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from kullanici where id=?");
                     ResultSet rs = sql.executeQuery();
                     rs.next();
                     kul = new Kullanici();
                     
                     kul.setId(rs.getInt("id"));
                     kul.setAd_soyad(rs.getString("ad_soyad"));
                     kul.setKullanici_adi(rs.getString("kullanici_adi"));
                     kul.setKullanici_sifresi(rs.getString("kullanici_sifresi"));
                     kul.setKullanici_mail(rs.getString("kullanici_mail"));
                     kul.setKullanici_cep(rs.getString("kullanici_cep"));
                     kul.setKayit_tarih(rs.getString("kayit_tarih"));
                    // kul.setKullaniciYetkileri(this.getYetDao().getKullaniciYetkileri(kul.getId()));
                  
                     
        }catch(SQLException ex){
             System.out.println("DAO Hata:" + ex.getMessage());
        }
        return kul;
    } 
    public YetkiDAO getYetDao() {
        if(this.yetDao==null){
            this.yetDao= new YetkiDAO();
        }
        return yetDao;
    }

    public void setYetDao(YetkiDAO yetDao) {
        this.yetDao = yetDao;
    }
    
    
}
