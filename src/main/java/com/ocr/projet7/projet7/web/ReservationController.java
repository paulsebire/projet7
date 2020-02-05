package com.ocr.projet7.projet7.web;


import com.ocr.projet7.projet7.dao.ReservationRepository;
import com.ocr.projet7.projet7.entities.Reservation;
import com.ocr.projet7.projet7.entities.Utilisateur;
import com.ocr.projet7.projet7.enums.RoleEnum;
import com.ocr.projet7.projet7.service.BibliServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController {
   @Autowired
   private ReservationRepository reservationRepository;
   @Autowired
   private BibliServiceImpl bibliService;

    @GetMapping(value = "/home")
    public String home(Model model){
        Utilisateur utilisateur = bibliService.userConnected();
        if (utilisateur.getRoles().contains(RoleEnum.ROLE_USER)){
            List<Reservation> listResabyUser= reservationRepository.findReservationByUtilisateurIdUserOrderByDateEmpruntAsc(utilisateur.getIdUser());
            model.addAttribute("listResa",listResabyUser);
            return "home";
        }else return "403";

    }

    @GetMapping(value = "/reservation/{id}/prolonger")
    public String prolongerReservation(Model model,
                                       @PathVariable(value = "id")Long id){
        Utilisateur utilisateur = bibliService.userConnected();
        Optional<Reservation> r= reservationRepository.findById(id);
        if (r.isPresent()){
            Reservation reservation=r.get();
            if (utilisateur.getRoles().contains(RoleEnum.ROLE_USER)&&utilisateur.getIdUser()==reservation.getUtilisateur().getIdUser()){
                reservation.setProlonger(true);
                reservation.setDateRetour(bibliService.ajouter4semaines(reservation.getDateRetour()));
                reservationRepository.save(reservation);
                List<Reservation> listResabyUser= reservationRepository.findReservationByUtilisateurIdUserOrderByDateEmpruntAsc(utilisateur.getIdUser());
                model.addAttribute("listResa",listResabyUser);
                return "home";
            }else return "403";
        }else return "redirect:/home";


    }

}
