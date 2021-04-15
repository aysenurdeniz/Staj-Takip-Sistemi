/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.YetkiDAO;
import entity.Yetki;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("yetkiConverter")
public class yetkiConverter implements Converter {

    private YetkiDAO yetkiDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getYetkiDao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Yetki yetki=(Yetki) o;
      return String.valueOf(yetki.getId());
    }
    
    

    public YetkiDAO getYetkiDao() {
        if (this.yetkiDao == null) {
            this.yetkiDao = new YetkiDAO();
        }
        return yetkiDao;
    }

    
}
