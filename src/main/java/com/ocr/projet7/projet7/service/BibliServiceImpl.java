package com.ocr.projet7.projet7.service;


import com.ocr.projet7.projet7.dao.ReservationRepository;
import com.ocr.projet7.projet7.entities.Reservation;
import com.ocr.projet7.projet7.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class BibliServiceImpl implements IBibliService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public Date ajouter4semaines(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 28);
        return cal.getTime();
    }

    @Override
    public Utilisateur userConnected(){
        Utilisateur utilisateur= (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return utilisateur;
    }

}
