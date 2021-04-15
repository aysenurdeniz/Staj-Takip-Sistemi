/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;


public class Bolum {
    private int id;
    private String bolum_adi;
    
    
    

    public Bolum() {
    }

    public Bolum(int id, String bolum_adi) {
        this.id = id;
        this.bolum_adi = bolum_adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBolum_adi() {
        return bolum_adi;
    }

    public void setBolum_adi(String bolum_adi) {
        this.bolum_adi = bolum_adi;
    }

    @Override
    public String toString() {
        return "Bolum{" + "id=" + id + ", bolum_adi=" + bolum_adi + '}';
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
        final Bolum other = (Bolum) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

 
    
    
}
