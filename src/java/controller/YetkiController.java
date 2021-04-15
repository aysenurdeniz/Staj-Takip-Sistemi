/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author hp
 */
import dao.YetkiDAO;
import entity.Yetki;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named("YetkiCont")
@SessionScoped

public class YetkiController implements Serializable {
    private Yetki yetki;
    private List<Yetki> yetkiList;
    private YetkiDAO yetkiDao;
    private String bul = "";
   

    public void kaydet() {
       
        this.getYetkiDao().ekle(this.yetki);
        this.formTemizle();
    }
    public void guncelle(){
        this.getYetkiDao().guncelle(this.yetki);
    }
    
    public String silmeOnay(Yetki yet) {
        this.yetki= yet;
        return "confirm_delete";
    }

    public void sil() {
        this.yetkiDao.sil(this.yetki);
        this.formTemizle();
    }

    public void formTemizle() {
        this.yetki = new Yetki();

    }

    public void guncelleForm(Yetki yetki) {

        this.yetki = yetki;
        
    }

    public Yetki getYetki() {
        if(this.yetki==null)
            this.yetki=new Yetki();
        return yetki;
    }

    public void setYetki(Yetki yetki) {
        this.yetki = yetki;
    }

    public List<Yetki> getYetkiList() {
        this.yetkiList=this.getYetkiDao().listele();
        return yetkiList;
    }

    public void setYetkiList(List<Yetki> yetkiList) {
        this.yetkiList = yetkiList;
    }

    public YetkiDAO getYetkiDao() {
        if(this.yetkiDao==null)
            this.yetkiDao=new YetkiDAO();
        return yetkiDao;
    }

    public void setYetkiDao(YetkiDAO yetkiDao) {
        this.yetkiDao = yetkiDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
    
    
}
