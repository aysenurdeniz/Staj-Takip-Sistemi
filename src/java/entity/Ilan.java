/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author toshiba
 */
public class Ilan {
    private int id;
    private String aciklama;
    private String ilan_tarih;

    public Ilan() {
    }

    public Ilan(int id, String aciklama, String ilan_tarih) {
        this.id = id;
        this.aciklama = aciklama;
        this.ilan_tarih = ilan_tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getIlan_tarih() {
        return ilan_tarih;
    }

    public void setIlan_tarih(String ilan_tarih) {
        this.ilan_tarih = ilan_tarih;
    }

    @Override
    public String toString() {
        return "Ilan{" + "id=" + id + ", aciklama=" + aciklama + ", ilan_tarih=" + ilan_tarih + '}';
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
        final Ilan other = (Ilan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
