/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MesajDAO;
import entity.Mesaj;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("MesajCont")
@SessionScoped
public class MesajController implements Serializable {
    
    private Mesaj mesaj;
    private MesajDAO mesajDao;
    private List<Mesaj> mesajList;
    private String bul="";
    
     public void kaydet() {
        System.out.println("********************** Test");
        this.getMesajDao().ekle(this.mesaj);
        this.formTemizle();
    }
     
    public void guncelle(){
        this.getMesajDao().guncelle(this.mesaj);
    }
    public String silmeOnay(Mesaj mes){
        this.mesaj=mes;
        return "confirm_delete";
    }

    public void sil() {
        this.mesajDao.sil(this.mesaj);
        this.formTemizle();
    }
    

    public void formTemizle() {
        this.mesaj = new Mesaj();

    }

    public void guncelleForm(Mesaj mesaj) {

        this.mesaj = mesaj;
        //this.selcilenKullanici=this.siparis.getKullanici().getId();
    }

    public Mesaj getMesaj() {
        if(this.mesaj==null)
            this.mesaj=new Mesaj();
        return mesaj;
    }

    public void setMesaj(Mesaj mesaj) {
        this.mesaj = mesaj;
    }

    public MesajDAO getMesajDao() {
        if(this.mesajDao==null)
            this.mesajDao=new MesajDAO();
        return mesajDao;
    }

    public void setMesajDao(MesajDAO mesajDao) {
        this.mesajDao = mesajDao;
    }

    public List<Mesaj> getMesajList() {
        this.mesajList=this.getMesajDao().listele();
        return mesajList;
    }

    public void setMesajList(List<Mesaj> mesajList) {
        this.mesajList = mesajList;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }
    
    
}
