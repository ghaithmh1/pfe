package com.pfe.prj1.service;

import com.pfe.prj1.model.Utilisateur;
import com.pfe.prj1.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Utilisateur signup(Utilisateur utilisateur) {
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return utilisateurRepository.save(utilisateur);
    }

    public boolean login(String email, String password) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmail(email);
        return utilisateurOpt.isPresent() && 
               passwordEncoder.matches(password, utilisateurOpt.get().getMotDePasse());
    }

    public String getRoleByEmail(String email) {
        Optional<Utilisateur> user = utilisateurRepository.findByEmail(email);
        return user.map(Utilisateur::getRole).orElse("USER");
    }
}