package com.ocr.projet7.projet7.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Reservation implements Serializable {
    @Id@GeneratedValue
    private Long id;

    private String livre;

    private Date dateEmprunt;

    private boolean prolonger;

    private String urlImg;

    private Date dateRetour;

    @OneToOne
    @JoinColumn(name ="id_user" )
    private Utilisateur utilisateur;

    public Reservation() {
        super();
    }

    public Reservation(String livre,Date dateEmprunt,Date dateRetour,boolean prolonger) {
        this.livre=livre;
        this.dateEmprunt=dateEmprunt;
        this.dateRetour=dateRetour;
        this.prolonger=false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLivre() {
        return livre;
    }

    public void setLivre(String livre) {
        this.livre = livre;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public boolean isProlonger() {
        return prolonger;
    }

    public void setProlonger(boolean prolonger) {
        this.prolonger = prolonger;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
