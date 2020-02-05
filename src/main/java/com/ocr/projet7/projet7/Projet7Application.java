package com.ocr.projet7.projet7;

import com.ocr.projet7.projet7.dao.ReservationRepository;
import com.ocr.projet7.projet7.entities.Reservation;
import com.ocr.projet7.projet7.entities.Utilisateur;
import com.ocr.projet7.projet7.security.UtilisateurService;
import com.ocr.projet7.projet7.service.BibliServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class Projet7Application {
@Autowired
private ReservationRepository reservationRepository;
@Autowired
private UtilisateurService utilisateurService;
@Autowired
private BibliServiceImpl bibliService;

    public static void main(String[] args) {
        SpringApplication.run(Projet7Application.class, args);
    }
    @PostConstruct
    private void postConstruct() {
        if (reservationRepository.findAll().isEmpty()){
            Utilisateur admin = (Utilisateur)utilisateurService.loadUserByUsername("admin");
            Utilisateur user = (Utilisateur)utilisateurService.loadUserByUsername("user");

            Reservation resa1 = new Reservation();
            resa1.setDateEmprunt(new Date());
            resa1.setDateRetour(bibliService.ajouter4semaines(resa1.getDateEmprunt()));
            resa1.setLivre("Le petit prince");
            resa1.setUrlImg("https://images-na.ssl-images-amazon.com/images/I/51WZzUKfHnL._SX330_BO1,204,203,200_.jpg");
            resa1.setUtilisateur(user);
            reservationRepository.save(resa1);

            Reservation resa2 = new Reservation();
            resa2.setDateEmprunt(new Date());
            resa2.setDateRetour(bibliService.ajouter4semaines(resa2.getDateEmprunt()));
            resa2.setLivre("Le chat botté");
            resa2.setUrlImg("https://images-na.ssl-images-amazon.com/images/I/513GI6j3dIL._SX360_BO1,204,203,200_.jpg");
            resa2.setUtilisateur(user);
            reservationRepository.save(resa2);

            Reservation resa3 = new Reservation();
            resa3.setDateEmprunt(new Date());
            resa3.setDateRetour(bibliService.ajouter4semaines(resa3.getDateEmprunt()));
            resa3.setLivre("Les contes de Grimm");
            resa3.setUrlImg("https://images-na.ssl-images-amazon.com/images/I/51QtHScO4zL._SX258_BO1,204,203,200_.jpg");
            resa3.setUtilisateur(user);
            reservationRepository.save(resa3);

            Reservation resa4 = new Reservation();
            resa4.setDateEmprunt(new Date());
            resa4.setDateRetour(bibliService.ajouter4semaines(resa1.getDateEmprunt()));
            resa4.setLivre("Le capital");
            resa4.setUrlImg("https://images-na.ssl-images-amazon.com/images/I/51gxl55u98L._SX306_BO1,204,203,200_.jpg");
            resa4.setUtilisateur(admin);
            reservationRepository.save(resa4);

            Reservation resa5 = new Reservation();
            resa5.setDateEmprunt(new Date());
            resa5.setDateRetour(bibliService.ajouter4semaines(resa5.getDateEmprunt()));
            resa5.setLivre("1984");
            resa5.setUrlImg("https://images-na.ssl-images-amazon.com/images/I/91SZSW8qSsL.jpg");
            resa5.setUtilisateur(admin);
            reservationRepository.save(resa5);

            Reservation resa6 = new Reservation();
            resa6.setDateEmprunt(new Date());
            resa6.setDateRetour(bibliService.ajouter4semaines(resa6.getDateEmprunt()));
            resa6.setLivre("Le meilleur des mondes");
            resa6.setUrlImg("https://images-na.ssl-images-amazon.com/images/I/41C-TnHVegL._SX303_BO1,204,203,200_.jpg");
            resa6.setUtilisateur(admin);
            reservationRepository.save(resa6);


        }
    }
}
