package com.ocr.projet7.projet7.dao;


import com.ocr.projet7.projet7.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByUsername(String username);
    Utilisateur findByEmail(String email);
}

