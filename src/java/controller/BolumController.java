/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BolumDAO;
import entity.Bolum;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("BolumCont")
@SessionScoped
public class BolumController implements Serializable{
 
    private Bolum bolum;
    private List<Bolum> bolumList;
    private BolumDAO bolumDao;
    private String bul = "";

    public void kaydet() {
        if (this.bolum.getId() == 0) {
            this.bolumDao.ekle(this.bolum);
        } else {
          this.bolumDao.guncelle(this.bolum);
        }
        this.formTemizle();
    }
    public void guncelle(){
        this.getBolumDao().guncelle(this.bolum);
    }

    public void sil() {
        this.bolumDao.sil(this.bolum);
        this.formTemizle();
    }
    
    public String silmeOnay(Bolum bol){
        this.bolum=bol;
        return "confirm_delete";
    }

    public void formTemizle() {
        this.bolum = new Bolum();

    }

    public void guncelleForm(Bolum bolum) {

        this.bolum = bolum;
       
    }

    public Bolum getBolum() {
        if(this.bolum==null)
            this.bolum=new Bolum();
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    public List<Bolum> getBolumList() {
        this.bolumList=this.getBolumDao().listele();
        return bolumList;
    }

    public void setBolumList(List<Bolum> bolumList) {
        this.bolumList = bolumList;
    }

    public BolumDAO getBolumDao() {
        if(this.bolumDao==null)
            this.bolumDao=new BolumDAO();
        return bolumDao;
    }

    public void setBolumDao(BolumDAO bolumDao) {
        this.bolumDao = bolumDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
   
}
