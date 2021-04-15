/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SektorDAO;
import entity.Sektor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named("SektorCont")
@SessionScoped
public class SektorController implements Serializable {
    
    private Sektor sektor;
    private List<Sektor> sektorList;
    private SektorDAO sektorDao;
    private String bul = "";
   

    public void kaydet() {
       
        this.getSektorDao().ekle(this.sektor);
        this.formTemizle();
    }
    public void guncelle(){
        this.getSektorDao().guncelle(this.sektor);
    }
    
    public String silmeOnay(Sektor sek) {
        this.sektor = sek;
        return "confirm_delete";
    }

    public void sil() {
        this.sektorDao.sil(this.sektor);
        this.formTemizle();
    }

    public void formTemizle() {
        this.sektor = new Sektor();

    }

    public void guncelleForm(Sektor sektor) {

        this.sektor = sektor;
        
    }

    public Sektor getSektor() {
        if(this.sektor==null)
            this.sektor=new Sektor();
        return sektor;
    }

    public void setSektor(Sektor sektor) {
        this.sektor = sektor;
    }

    public List<Sektor> getSektorList() {
        
        this.sektorList=this.getSektorDao().listele();
        return sektorList;
    }

    public void setSektorList(List<Sektor> sektorList) {
        this.sektorList = sektorList;
    }

    public SektorDAO getSektorDao() {
        if(this.sektorDao==null)
            this.sektorDao=new SektorDAO();
        return sektorDao;
    }

    public void setSektorDao(SektorDAO sektorDao) {
        this.sektorDao = sektorDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
    
    
}

