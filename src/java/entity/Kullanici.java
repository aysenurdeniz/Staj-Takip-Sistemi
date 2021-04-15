package entity;



public class Kullanici {
    private int id;
    private String ad_soyad;
    private String kullanici_adi;
    private String kullanici_sifresi;
    private String kullanici_mail;
    private String kullanici_cep;
    private String kayit_tarih ;

    public Kullanici() {
    }

    public Kullanici(int id, String ad_soyad, String kullanici_adi, String kullanici_sifresi, String kullanici_mail, String kullanici_cep, String kayit_tarih) {
        this.id = id;
        this.ad_soyad = ad_soyad;
        this.kullanici_adi = kullanici_adi;
        this.kullanici_sifresi = kullanici_sifresi;
        this.kullanici_mail = kullanici_mail;
        this.kullanici_cep = kullanici_cep;
        this.kayit_tarih = kayit_tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getKullanici_sifresi() {
        return kullanici_sifresi;
    }

    public void setKullanici_sifresi(String kullanici_sifresi) {
        this.kullanici_sifresi = kullanici_sifresi;
    }

    public String getKullanici_mail() {
        return kullanici_mail;
    }

    public void setKullanici_mail(String kullanici_mail) {
        this.kullanici_mail = kullanici_mail;
    }

    public String getKullanici_cep() {
        return kullanici_cep;
    }

    public void setKullanici_cep(String kullanici_cep) {
        this.kullanici_cep = kullanici_cep;
    }

    public String getKayit_tarih() {
        return kayit_tarih;
    }

    public void setKayit_tarih(String kayit_tarih) {
        this.kayit_tarih = kayit_tarih;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "id=" + id + ", ad_soyad=" + ad_soyad + ", kullanici_adi=" + kullanici_adi + ", kullanici_sifresi=" + kullanici_sifresi + ", kullanici_mail=" + kullanici_mail + ", kullanici_cep=" + kullanici_cep + ", kayit_tarih=" + kayit_tarih + '}';
    }
 
    
    
    
}

   
