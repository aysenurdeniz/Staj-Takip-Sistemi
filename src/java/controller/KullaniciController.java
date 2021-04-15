/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KullaniciDAO;
import dao.YetkiDAO;

import entity.Kullanici;
import entity.Yetki;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
//import javax.enterprise.context.SessionScoped;



import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named("KullaniciCont")
@SessionScoped
public class KullaniciController implements Serializable {

    private Kullanici kullanici;
    private List<Kullanici> kullaniciList;
    private KullaniciDAO kullaniciDao;
    private String bul = "";
    
    @Inject
    private YetkiController yetkiController;
    
    private List<Yetki> yetkiList;
    private YetkiDAO yetkiDao;
    
    public void kaydet() {
        System.out.println("********************** Test");
        this.getKullaniciDao().ekle(this.kullanici);
        this.formTemizle();
    }

    public void guncelle() {
        this.getKullaniciDao().guncelle(this.kullanici);
    }
    public String silmeOnay(Kullanici kul){
        this.kullanici=kul;
        return "confirm_delete";
    }

    public void sil() {
        this.kullaniciDao.sil(this.kullanici);
        this.formTemizle();
    }

    public void formTemizle() {
        this.kullanici = new Kullanici();

    }

    public void guncelleForm(Kullanici kullanici) {

        this.kullanici = kullanici;

    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public List<Kullanici> getKullaniciList() {
       
         this.kullaniciList = this.getKullaniciDao().listele();
         
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public KullaniciDAO getKullaniciDao() {
        if (this.kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public List<Yetki> getYetkiList() {
        if(this.yetkiList==null){
            this.yetkiList=this.yetkiDao.listele();
        }
        return yetkiList;
    }

    public void setYetkiList(List<Yetki> yetkiList) {
        this.yetkiList = yetkiList;
    }

    public YetkiDAO getYetkiDao() {
        if(this.yetkiDao==null){
            yetkiDao=new YetkiDAO();
        }
        return yetkiDao;
    }

    public void setYetkiDao(YetkiDAO yetkiDao) {
        this.yetkiDao = yetkiDao;
    }

}
