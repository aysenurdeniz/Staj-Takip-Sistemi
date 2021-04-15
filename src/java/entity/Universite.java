/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Universite {
    private int id;
    private String universite_adi;
    private Bolum bolum;

    
    public Universite() {
    }

    public Universite(int id, String universite_adi) {
        this.id = id;
        this.universite_adi = universite_adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversite_adi() {
        return universite_adi;
    }

    public void setUniversite_adi(String universite_adi) {
        this.universite_adi = universite_adi;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }
    

    @Override
    public String toString() {
        return "Universite{" + "id=" + id + ", universite_adi=" + universite_adi + '}';
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
        final Universite other = (Universite) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
