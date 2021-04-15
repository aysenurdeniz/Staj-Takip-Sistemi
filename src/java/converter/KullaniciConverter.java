/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import dao.KullaniciDAO;
import entity.Kullanici;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 *  
 */


@FacesConverter("kullaniciConverter")
public class KullaniciConverter implements Converter {

    private KullaniciDAO kullaniciDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getKullaniciDao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Kullanici kullanici=(Kullanici) o;
      return String.valueOf(kullanici.getId());
    }

    public KullaniciDAO getKullaniciDao() {
        if(this.kullaniciDao==null)
            this.kullaniciDao=new KullaniciDAO();
        return kullaniciDao;
    }
    
    
    
}
