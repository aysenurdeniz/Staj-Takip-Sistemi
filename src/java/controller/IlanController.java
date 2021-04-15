/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IlanDAO;
import entity.Ilan;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author toshiba
 */
@Named("ilanCont")
@SessionScoped()
public class IlanController implements Serializable{
    private Ilan ilan;
    private List<Ilan> ilanList;
    private IlanDAO ilanDao;
    private String bul="";
    
    
    public void kaydet() {
    this.getIlanDao().ekle(this.ilan);
    this.formTemizle();
    }

    
    public void guncelle(){
        this.getIlanDao().guncelle(this.ilan);
    }
    
    
    public void sil() {
        this.getIlanDao().sil(this.ilan);
        this.formTemizle();
    }
    
   public void formTemizle(){
       this.ilan= new Ilan();
   } 
    
   public void guncelleForm(Ilan ilan){
       this.ilan= ilan;
   }
   
   
    
    
    public Ilan getIlan() {
        if(this.ilan==null)
            this.ilan= new Ilan();
        return ilan;
    }

    public void setIlan(Ilan ilan) {
        this.ilan = ilan;
    }

    public List<Ilan> getIlanList() {
        if(this.ilanList==null)
            this.ilanList= this.getIlanDao().listele();
        return ilanList;
    }

    public void setIlanList(List<Ilan> ilanList) {
        this.ilanList = ilanList;
    }

    public IlanDAO getIlanDao() {
        if(this.ilanDao==null)
            this.ilanDao= new IlanDAO();
        return ilanDao;
    }

    public void setIlanDao(IlanDAO ilanDao) {
        this.ilanDao = ilanDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

   
 
    
}
