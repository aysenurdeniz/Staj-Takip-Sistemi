/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UniversiteDAO;
import entity.Universite;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named("UniversiteCont")
@SessionScoped
public class UniversiteController implements Serializable {
    
    private Universite universite;
    private List<Universite> universiteList;
    private UniversiteDAO universiteDao;
    private String bul = "";


    public void kaydet() {
       
        this.getUniversiteDao().ekle(this.universite);
        this.formTemizle();
    }
    
    public void guncelle(){
        this.getUniversiteDao().guncelle(this.universite);
    }
    public String silmeOnay(Universite unv) {
        this.universite =unv;
        return "confirm_delete";
    }

    public void sil() {
        this.universiteDao.sil(this.universite);
        this.formTemizle();
    }

    public void formTemizle() {
        this.universite = new Universite();

    }

    public void guncelleForm(Universite universite) {

        this.universite = universite;
        
    }

    public Universite getUniversite() {
        if(this.universite==null)
            this.universite=new Universite();
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public List<Universite> getUniversiteList() {
        if(this.universiteList==null)
            this.universiteList=this.getUniversiteDao().listele();
        return universiteList;
    }

    public void setUniversiteList(List<Universite> universiteList) {
        this.universiteList = universiteList;
    }

    public UniversiteDAO getUniversiteDao() {
        if(this.universiteDao==null)
            this.universiteDao=new UniversiteDAO();
        return universiteDao;
    }

    public void setUniversiteDao(UniversiteDAO universiteDao) {
        this.universiteDao = universiteDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
    
    
}

