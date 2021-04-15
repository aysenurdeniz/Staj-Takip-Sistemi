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
public class Kurum {
    private int id;
    private String kurum_adi;
    private String kurum_adresi;
    
    private List<Sektor> kurum_Sektor;

    public List<Sektor> getKurum_Sektor() {
        return kurum_Sektor;
    }

    public void setKurum_Sektor(List<Sektor> kurum_Sektor) {
        this.kurum_Sektor = kurum_Sektor;
    }

    @Override
    public String toString() {
        return "Kurum{" + "id=" + id + ", kurum_adi=" + kurum_adi + ", kurum_adresi=" + kurum_adresi + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKurum_adi() {
        return kurum_adi;
    }

    public void setKurum_adi(String kurum_adi) {
        this.kurum_adi = kurum_adi;
    }

    public String getKurum_adresi() {
        return kurum_adresi;
    }

    public void setKurum_adresi(String kurum_adresi) {
        this.kurum_adresi = kurum_adresi;
    }

    public Kurum() {
    }

    public Kurum(int id, String kurum_adi, String kurum_adresi) {
        this.id = id;
        this.kurum_adi = kurum_adi;
        this.kurum_adresi = kurum_adresi;
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
        final Kurum other = (Kurum) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
