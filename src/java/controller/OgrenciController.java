/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OgrenciDAO;

import entity.Ogrenci;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

//import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named ("OgrenciCont")
@SessionScoped
public class OgrenciController implements Serializable {

    private List<Ogrenci> ogrenciList;
    private OgrenciDAO ogrenciDao;
    private Ogrenci ogrenci;
    private String bul="";
    
     public void kaydet() {
       
       this.getOgrenciDao().ekle(this.ogrenci);
        this.formTemizle();
    }
    public void guncelle(){
        this.getOgrenciDao().guncelle(this.ogrenci);
    }
    public String silmeOnay(Ogrenci ogr){
        this.ogrenci=ogr;
        return "confirm_delete";
    }

    public void sil() {
        this.ogrenciDao.sil(this.ogrenci);
        this.formTemizle();
    }

    public void formTemizle() {
        this.ogrenci = new Ogrenci();

    }

    public void guncelleForm(Ogrenci ogrenci) {

        this.ogrenci = ogrenci;
        
    }

    public List<Ogrenci> getOgrenciList() {
        this.ogrenciList=this.getOgrenciDao().listele();
        return ogrenciList;
    }

    public void setOgrenciList(List<Ogrenci> ogrenciList) {
        this.ogrenciList = ogrenciList;
    }

    public OgrenciDAO getOgrenciDao() {
        if(this.ogrenciDao==null){
            this.ogrenciDao=new OgrenciDAO();
        }
        return ogrenciDao;
    }

    public void setOgrenciDao(OgrenciDAO ogrenciDao) {
        this.ogrenciDao = ogrenciDao;
    }

    public Ogrenci getOgrenci() {
        if(this.ogrenci==null){
            this.ogrenci=new Ogrenci();
        }
       
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    
    

   
   
   
}
