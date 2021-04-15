
package entity;


public class GenelAyarlar {
    
    private int id;
    private String Firma_Adi;
    private String Alt_Bilgi;
    private String Site_Renk;
    private String Admin_Renk;

    public GenelAyarlar() {
    }
    
    public GenelAyarlar(int id, String Firma_Adi, String Alt_Bilgi, String Site_Renk, String Admin_Renk) {
        this.id = id;
        this.Firma_Adi = Firma_Adi;
        this.Alt_Bilgi = Alt_Bilgi;
        this.Site_Renk = Site_Renk;
        this.Admin_Renk = Admin_Renk;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirma_Adi() {
        return Firma_Adi;
    }

    public void setFirma_Adi(String Firma_Adi) {
        this.Firma_Adi = Firma_Adi;
    }

    public String getAlt_Bilgi() {
        return Alt_Bilgi;
    }

    public void setAlt_Bilgi(String Alt_Bilgi) {
        this.Alt_Bilgi = Alt_Bilgi;
    }

    public String getSite_Renk() {
        return Site_Renk;
    }

    public void setSite_Renk(String Site_Renk) {
        this.Site_Renk = Site_Renk;
    }

    public String getAdmin_Renk() {
        return Admin_Renk;
    }

    public void setAdmin_Renk(String Admin_Renk) {
        this.Admin_Renk = Admin_Renk;
    }

    @Override
    public String toString() {
        return "GenelAyarlar{" + "id=" + id + ", Firma_Adi=" + Firma_Adi + ", Alt_Bilgi=" + Alt_Bilgi + ", Site_Renk=" + Site_Renk + ", Admin_Renk=" + Admin_Renk + '}';
    }
    
    
}
