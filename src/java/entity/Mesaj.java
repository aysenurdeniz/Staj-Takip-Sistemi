/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Kullanici;

/**
 *
 * @author hp
 */

public class Mesaj {
    
    private int id;
    private String ad_soyad;
    private String e_mail;
    private String cep_numarasi;
    private String konu;
    private String baslik;

    public Mesaj() {
    }

    public Mesaj(int id, String ad_soyad, String e_mail, String cep_numarasi, String konu, String baslik) {
        this.id = id;
        this.ad_soyad = ad_soyad;
        this.e_mail = e_mail;
        this.cep_numarasi = cep_numarasi;
        this.konu = konu;
        this.baslik = baslik;
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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getCep_numarasi() {
        return cep_numarasi;
    }

    public void setCep_numarasi(String cep_numarasi) {
        this.cep_numarasi = cep_numarasi;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    @Override
    public String toString() {
        return "Mesaj{" + "id=" + id + ", ad_soyad=" + ad_soyad + ", e_mail=" + e_mail + ", cep_numarasi=" + cep_numarasi + ", konu=" + konu + ", baslik=" + baslik + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Mesaj other = (Mesaj) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
