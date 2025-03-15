package com.pfe.prj1.controller;

import com.pfe.prj1.model.Compte;
import com.pfe.prj1.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @PostMapping
    public Compte createCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @GetMapping("/{id}")
    public Compte getCompteById(@PathVariable int id) {
        return compteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Compte updateCompte(@PathVariable int id, @RequestBody Compte compteDetails) {
        Compte compte = compteRepository.findById(id).orElse(null);
        if (compte != null) {
            compte.setNom(compteDetails.getNom());
            return compteRepository.save(compte);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable int id) {
        compteRepository.deleteById(id);
    }
}