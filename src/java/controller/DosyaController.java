/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DosyaDAO;
import entity.Dosya;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("DosyaCont")
@SessionScoped

public class DosyaController implements Serializable {
    private Dosya dosya;
    private DosyaDAO dosyaDao;
    private List<Dosya> dosyaList;
    private String bul ="";

     
    public void kaydet() {
        System.out.println("********************** Test");
        this.getDosyaDao().ekle(this.dosya);
        this.formTemizle();
    }
    
    public void guncelle(){
        this.getDosyaDao().guncelle(this.dosya);
    }
    
    public String silmeOnay(Dosya dos){
        this.dosya=dos;
        return "confirm_delete";
    }

    public void sil() {
        this.dosyaDao.sil(this.dosya);
        this.formTemizle();
    }

    public void formTemizle() {
        this.dosya = new Dosya();

    }

    public void guncelleForm(Dosya dosya) {

        this.dosya = dosya;
       
    }
    

    public Dosya getDosya() {
        if(this.dosya==null)
            this.dosya=new Dosya();
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }

    public DosyaDAO getDosyaDao() {
        if(this.dosyaDao==null)
            this.dosyaDao=new DosyaDAO();
        return dosyaDao;
    }

    public void setDosyaDao(DosyaDAO dosyaDao) {
        this.dosyaDao = dosyaDao;
    }

    public List<Dosya> getDosyaList() {
        this.dosyaList=this.getDosyaDao().listele();
        return dosyaList;
    }

    public void setDosyaList(List<Dosya> dosyaList) {
        this.dosyaList = dosyaList;
    }
       public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
 
}
