/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KurumDAO;
import entity.Kurum;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author hp
 */
@Named("kurumCont")
@SessionScoped
public class KurumController implements Serializable {

    private Kurum kurum;
    private List<Kurum> kurumList;
    private KurumDAO kurumDao;
    private String bul = "";

    @Inject
    private SektorController sektorController;
    
    
    public void kaydet() {
        System.out.println("********************** Test");
        this.getKurumDao().ekle(this.kurum);
        this.formTemizle();
    }
    public void guncelle(){
        this.getKurumDao().guncelle(this.kurum);
    }
    
    public String silmeOnay(Kurum kur){
        this.kurum=kur;
        return "confirm_delete";
    }

    public void sil() {
        this.kurumDao.sil(this.kurum);
        this.formTemizle();
    }

    public void formTemizle() {
        this.kurum = new Kurum();

    }

    public void guncelleForm(Kurum kurum) {

        this.kurum = kurum;
        //this.selcilenKullanici=this.siparis.getKullanici().getId();
    }

    public Kurum getKurum() {
        if (kurum == null) {
            this.kurum = new Kurum();
        }
        return kurum;
    }

    public void setKurum(Kurum kurum) {
        this.kurum = kurum;
    }

    public List<Kurum> getKurumList() {

        this.kurumList = this.getKurumDao().listele();
        return kurumList;
    }

    public void setKurumList(List<Kurum> kurumList) {
        this.kurumList = kurumList;
    }

    public KurumDAO getKurumDao() {
        if (kurumDao == null) {
            this.kurumDao = new KurumDAO();
        }
        return kurumDao;
    }

    public void setKurumDao(KurumDAO kurumDao) {
        this.kurumDao = kurumDao;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public SektorController getSektorController() {
        if(this.sektorController==null){
            sektorController= new SektorController();
        }
        return sektorController;
    }

    public void setSektorController(SektorController sektorController) {
        this.sektorController = sektorController;
    }

}
