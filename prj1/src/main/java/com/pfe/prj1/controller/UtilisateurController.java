package com.pfe.prj1.controller;

import com.pfe.prj1.model.Utilisateur;
import com.pfe.prj1.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/register")
    public ResponseEntity<Utilisateur> register(@RequestBody Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurService.registerUtilisateur(utilisateur);
        return ResponseEntity.ok(savedUtilisateur);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUtilisateur(@RequestBody Utilisateur loginRequest) {
        String token = utilisateurService.loginUtilisateur(loginRequest.getEmail(), loginRequest.getMotDePasse());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable int id, @RequestBody Utilisateur utilisateurDetails) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateurDetails);
        if (updatedUtilisateur != null) {
            return ResponseEntity.ok(updatedUtilisateur);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable int id) {
        if (utilisateurService.deleteUtilisateurById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
