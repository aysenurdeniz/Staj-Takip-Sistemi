package controller;

import dao.GenelAyarlarDAO;
import entity.GenelAyarlar;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("genelAyarlarController")
@ViewScoped
public class GenelAyarlarController implements Serializable {

    private GenelAyarlar genelayarlar;
    private GenelAyarlarDAO GenelAyarlarDao;

    public GenelAyarlarController() {
         this.genelayarlar=this.getGenelAyarlarDao().getir();
    }
    
    
    
    public void kaydet() {

        this.getGenelAyarlarDao().guncelle(this.genelayarlar);//guncelle

    }

    public void guncelleForm(GenelAyarlar genelayarlar) {
        this.genelayarlar = genelayarlar;
    }

    public GenelAyarlar getGenelayarlar() {
        if (this.genelayarlar == null) {
            this.genelayarlar = new GenelAyarlar();
        }
        return genelayarlar;
    }

    public void setGenelayarlar(GenelAyarlar genelayarlar) {
        this.genelayarlar = genelayarlar;
    }

    public GenelAyarlarDAO getGenelAyarlarDao() {
         if (this.GenelAyarlarDao == null) {
            this.GenelAyarlarDao = new GenelAyarlarDAO();
        }
        return GenelAyarlarDao;
    }

    

    public void setGenelAyarlarDao(GenelAyarlarDAO GenelAyarlarDao) {
        this.GenelAyarlarDao = GenelAyarlarDao;
    }

}
