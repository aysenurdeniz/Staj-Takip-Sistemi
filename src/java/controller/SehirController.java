/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SehirDAO;
import entity.Sehir;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("SehirCont")
@SessionScoped
public class SehirController implements Serializable {

    private Sehir sehir;
    private List<Sehir> sehirList;
    private SehirDAO sehirDao;
    private String bul = "";

    public void kaydet() {

        this.getSehirDao().ekle(this.sehir);
        this.formTemizle();
    }

    public void guncelle() {
        this.getSehirDao().guncelle(this.sehir);
    }

    public String silmeOnay(Sehir seh) {
        this.sehir = seh;
        return "confirm_delete";
    }

    public void sil() {
        this.sehirDao.sil(this.sehir);
        this.formTemizle();
    }

    public void formTemizle() {
        this.sehir = new Sehir();

    }

    public void guncelleForm(Sehir sehir) {

        this.sehir = sehir;

    }

    public Sehir getSehir() {
        if (this.sehir == null) {
            this.sehir = new Sehir();
        }
        return sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    public List<Sehir> getSehirList() {
        
        this.sehirList = this.getSehirDao().listele();
        return sehirList;
    }

    public void setSehirList(List<Sehir> sehirList) {
        this.sehirList = sehirList;
    }

    public SehirDAO getSehirDao() {
        if (this.sehirDao == null) {
            this.sehirDao = new SehirDAO();
        }
        return sehirDao;
    }

    public void setSehirDao(SehirDAO sehirDao) {
        this.sehirDao = sehirDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
    

}
