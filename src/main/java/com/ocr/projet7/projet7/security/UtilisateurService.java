package com.ocr.projet7.projet7.security;

import com.ocr.projet7.projet7.dao.UtilisateurRepository;
import com.ocr.projet7.projet7.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UtilisateurService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository=utilisateurRepository;
    }

    /**
     * this method load a user by his username
     * @param username name of user
     * @return an  object user fulfill with informations belonging to username
     * @throws UsernameNotFoundException an exception if user not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("No user present with username : " + username);
        }
        else {
            return utilisateur;
        }
    }



}