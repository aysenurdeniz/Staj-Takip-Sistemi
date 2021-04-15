package dao;

import entity.Yetki;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class YetkiDAO extends AbstractDAO {

  

     public void ekle(Yetki yetki) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("insert into yetki (yetki_adi,kayıt_kullanici) values(?,?)");
            sql.setString(1, yetki.getYetki_adi());
            sql.setString(2, yetki.getKayit_kullanici());
            
           
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO EKLEME HATASI:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void sil(Yetki yetki) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("delete from yetki where id=?");
            sql.setInt(1, yetki.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO SİLME HATA" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public void guncelle(Yetki yetki) {

        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("update yetki set yetki_adi=?, kayıt_kullanici=? where id=?");
            sql.setString(1, yetki.getYetki_adi());
            sql.setString(2, yetki.getKayit_kullanici());
            
            sql.setInt(3,yetki.getId());
            sql.executeUpdate();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO GUNCELLEME HATA:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
    }

    public List<Yetki> listele() {
        List<Yetki> yetkiList = new ArrayList();
        
        try {

            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from yetki ");

          
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Yetki yetki=new Yetki();
                
                    yetki.setId(rs.getInt("id"));
                    yetki.setYetki_adi(rs.getString("yetki_adi"));
                    yetki.setKayit_kullanici(rs.getString("kayit_kullanici"));
                   yetki.setKayit_tarihi(rs.getString("kayit_tarihi"));

                yetkiList.add(yetki);

            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("DAO Hata:" + ex.getMessage());
        } finally {
            this.disconnect();
        }
        return yetkiList;
    }

    public List<Yetki> getKullaniciYetkileri(int id) {
        List<Yetki> list = new ArrayList<>();
        
        try {
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from kullanici_yetki where id =?");
            
                    sql.setInt(1, id);
                    ResultSet rs = sql.executeQuery();
                    
                    while(rs.next()){
                        list.add(this.find(rs.getInt(id)));
                    }
        }catch(SQLException ex){
            System.out.println("DAO Hata:" + ex.getMessage());
        }
        return list;
    }

    public Yetki find(int id) {
        Yetki yet =null;
        try{
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from yetki where id=?");
                    sql.setInt(1, id);
                    ResultSet rs = sql.executeQuery();
                    rs.next();
                    
                    yet = new Yetki();
                    yet.setId(rs.getInt("id"));
                    yet.setYetki_adi(rs.getString("yetki_adi"));
                    yet.setKayit_kullanici(rs.getString("kayit_kullanici"));
                    yet.setKayit_tarihi(rs.getString("kayit_tarihi"));
        }catch(SQLException ex){
             System.out.println("DAO Hata:" + ex.getMessage());
        }
        return yet;
    
    }
}
    

