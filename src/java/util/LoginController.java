/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Kullanici;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;

/**
 *
 * @author Deniz
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    private Kullanici kullanici;

    public String giris() {
        if (this.kullanici.getKullanici_adi().equals("kullanici") && this.kullanici.getKullanici_sifresi().equals("1234")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("KullaniciA", this.kullanici);
            return "/back_end/kullanici/Kullanici?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı giris!"));
            return "/front_end/ortak/login?faces-redirect=true";
        }

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

}
