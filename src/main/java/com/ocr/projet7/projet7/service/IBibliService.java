package com.ocr.projet7.projet7.service;


import com.ocr.projet7.projet7.entities.Reservation;
import com.ocr.projet7.projet7.entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface IBibliService {
    public Date ajouter4semaines(Date date);
    public Utilisateur userConnected();
}
