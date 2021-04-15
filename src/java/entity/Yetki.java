package entity;

import java.util.List;


public class Yetki {
    private int id;
    private String yetki_adi;
    private String kayit_kullanici;
    private String kayit_tarihi;
    private List<Kullanici> yetkiKullanici;

    public Yetki() {
    }

    public Yetki(int id, String yetki_adi, String kayit_kullanici, String kayit_tarihi) {
        this.id = id;
        this.yetki_adi = yetki_adi;
        this.kayit_kullanici = kayit_kullanici;
        this.kayit_tarihi = kayit_tarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYetki_adi() {
        return yetki_adi;
    }

    public void setYetki_adi(String yetki_adi) {
        this.yetki_adi = yetki_adi;
    }

    public String getKayit_kullanici() {
        return kayit_kullanici;
    }

    public void setKayit_kullanici(String kayit_kullanici) {
        this.kayit_kullanici = kayit_kullanici;
    }

    public String getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(String kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    public List<Kullanici> getYetkiKullanici() {
        return yetkiKullanici;
    }

    public void setYetkiKullanici(List<Kullanici> yetkiKullanici) {
        this.yetkiKullanici = yetkiKullanici;
    }

    @Override
    public String toString() {
        return "Yetki{" + "id=" + id + ", yetki_adi=" + yetki_adi + ", kayit_kullanici=" + kayit_kullanici + ", kayit_tarihi=" + kayit_tarihi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Yetki other = (Yetki) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    

}