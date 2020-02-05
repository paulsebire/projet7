package com.ocr.projet7.projet7.web;


import com.ocr.projet7.projet7.dao.UtilisateurRepository;
import com.ocr.projet7.projet7.entities.Utilisateur;
import com.ocr.projet7.projet7.enums.RoleEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private static final Logger logger = LogManager.getLogger(UtilisateurController.class);


    /**
     * this method return the inscription form
     * @param model instance of model
     * @return the form for inscription
     */
    @GetMapping(value = "/utilisateur/inscription")
    public String inscriptionForm(Model model){
        Utilisateur utilisateur=new Utilisateur();
        logger.info("Un visiteur veut accéder au formulaire d'inscription");
        model.addAttribute("utilisateur",utilisateur);
        return "inscription";
    }

    /**
     * this method check if username and email are available
     * then add the new user to DB
     * @param model instance of model
     * @param utilisateur  an object utilisateur
     * @param bindingResult handle the errors
     * @return a confirmation page
     */
    @PostMapping(value = "/utilisateur/create")
    public String saveNewUtilisateur(Model model, @Valid Utilisateur utilisateur, BindingResult bindingResult){
            if (utilisateurRepository.findByUsername(utilisateur.getUsername())==null && utilisateurRepository.findByEmail(utilisateur.getEmail())==null){
                utilisateur.getRoles().add(RoleEnum.ROLE_USER);
                utilisateurRepository.save(utilisateur);
                model.addAttribute("utilisateur",utilisateur);
                logger.info("L'utilisateur "+utilisateur.getUsername()+" a été ajouté a la DB");
                return "confirmationUtilisateur";
            }else{
                if (utilisateurRepository.findByUsername(utilisateur.getUsername().toLowerCase())!=null ){
                    bindingResult.rejectValue("username","utilisateur.username", "ce pseudo est déjà utilisé :(");
                }
                if (utilisateurRepository.findByEmail(utilisateur.getEmail().toLowerCase())!=null){
                    bindingResult.rejectValue("email","utilisateur.email", "cet e-mail est déjà associé à un autre compte :(");
                }
                model.addAttribute("utilisateur",utilisateur);
                return "inscription";
            }
    }


}
