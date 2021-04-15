/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author hp
 */
public class Sektor {
    private int id;
    private String sektor_adi;
    
    private List<Kurum> kurum_sektor;
    

    public Sektor() {
    }

    public Sektor(int id, String sektor_adi, Boolean saha_alani) {
        this.id = id;
        this.sektor_adi = sektor_adi;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSektor_adi() {
        return sektor_adi;
    }

    public void setSektor_adi(String sektor_adi) {
        this.sektor_adi = sektor_adi;
    }

    public List<Kurum> getKurum_sektor() {
        return kurum_sektor;
    }

    public void setKurum_sektor(List<Kurum> kurum_sektor) {
        this.kurum_sektor = kurum_sektor;
    }

   

    @Override
    public String toString() {
        return "Sektor{" + "id=" + id + ", sektor_adi=" + sektor_adi +  '}';
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
        final Sektor other = (Sektor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
