/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author hp
 */
public class Ogrenci {
    private int id;
    private String ad_soyad;
    private String cep_numara;
    private String e_mail;

    private Universite universite;
    public Ogrenci(){
        
    }

    public Ogrenci(int id, String ad_soyad, String cep_numara, String e_mail) {
        this.id = id;
        this.ad_soyad = ad_soyad;
        this.cep_numara = cep_numara;
        this.e_mail = e_mail;
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

    public String getCep_numara() {
        return cep_numara;
    }

    public void setCep_numara(String cep_numara) {
        this.cep_numara = cep_numara;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
    
    

    @Override
    public String toString() {
        return "Ogrenci{" + "id=" + id + ", ad_soyad=" + ad_soyad + ", cep_numara=" + cep_numara + ", e_mail=" + e_mail + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ogrenci other = (Ogrenci) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


 
}
