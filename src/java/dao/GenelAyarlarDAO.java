
package dao;

import entity.GenelAyarlar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class GenelAyarlarDAO extends AbstractDAO{
    
    PreparedStatement sql = null;
     ResultSet rs = null;
    
    public void guncelle(GenelAyarlar genelayarlar) {

        try {
            sql = this.getConnection()
                    .prepareStatement("update genelayarlar set Firma_Adi=?,Alt_Bilgi=?,Site_Renk= ?,Admin_Renk= ? WHERE id = ?");
            sql.setString(1, genelayarlar.getFirma_Adi());
            sql.setString(2, genelayarlar.getAlt_Bilgi());
            sql.setString(3, genelayarlar.getSite_Renk());
            sql.setString(4, genelayarlar.getAdmin_Renk());
            
            sql.setInt(5, genelayarlar.getId());
            sql.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("DAO Hata :"+ex.getMessage());
        }

    }
    public GenelAyarlar getir() {
        GenelAyarlar nesne =null;
        try {
            
            PreparedStatement sql = this.getConnection()
                    .prepareStatement("select * from genelayarlar ");
            
            rs = sql.executeQuery();
            rs.next();
                nesne = new GenelAyarlar();
                nesne.setId(rs.getInt("id"));
                nesne.setAdmin_Renk(rs.getString("admin_renk"));
                nesne.setAlt_Bilgi(rs.getString("alt_bilgi"));
                nesne.setFirma_Adi(rs.getString("firma_adi"));
                nesne.setSite_Renk(rs.getString("site_renk"));
  

        } catch (SQLException ex) {
            System.out.println("Guncelleme Hata"+ex.getMessage());
        }
        return nesne;
    }

    
}
