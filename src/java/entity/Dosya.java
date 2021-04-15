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
public class Dosya {
    private int id;
    private String dosya_adi;
    private String dosya_boyutu;
    private String dosya_yolu;
    private String dosya_tipi;

    public Dosya() {
    }

    public Dosya(int id, String dosya_adi, String dosya_boyutu, String dosya_yolu, String dosya_tipi) {
        this.id = id;
        this.dosya_adi = dosya_adi;
        this.dosya_boyutu = dosya_boyutu;
        this.dosya_yolu = dosya_yolu;
        this.dosya_tipi = dosya_tipi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDosya_adi() {
        return dosya_adi;
    }

    public void setDosya_adi(String dosya_adi) {
        this.dosya_adi = dosya_adi;
    }

    public String getDosya_boyutu() {
        return dosya_boyutu;
    }

    public void setDosya_boyutu(String dosya_boyutu) {
        this.dosya_boyutu = dosya_boyutu;
    }

    public String getDosya_yolu() {
        return dosya_yolu;
    }

    public void setDosya_yolu(String dosya_yolu) {
        this.dosya_yolu = dosya_yolu;
    }

    public String getDosya_tipi() {
        return dosya_tipi;
    }

    public void setDosya_tipi(String dosya_tipi) {
        this.dosya_tipi = dosya_tipi;
    }

    @Override
    public String toString() {
        return "Dosya{" + "id=" + id + ", dosya_adi=" + dosya_adi + ", dosya_boyutu=" + dosya_boyutu + ", dosya_yolu=" + dosya_yolu + ", dosya_tipi=" + dosya_tipi + '}';
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
        final Dosya other = (Dosya) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
