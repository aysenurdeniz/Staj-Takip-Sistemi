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
public class Sehir {
    private int id;
    private String sehir_adi;
    

    public Sehir() {
    }

    public Sehir(int id, String sehir_adi, String ilce) {
        this.id = id;
        this.sehir_adi = sehir_adi;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSehir_adi() {
        return sehir_adi;
    }

    public void setSehir_adi(String sehir_adi) {
        this.sehir_adi = sehir_adi;
    }

 

    @Override
    public String toString() {
        return "Sehir{" + "id=" + id + ", sehir_adi=" + sehir_adi +  '}';
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
        final Sehir other = (Sehir) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
