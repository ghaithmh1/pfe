package com.pfe.prj1.service;

import com.pfe.prj1.model.Compte;
import com.pfe.prj1.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Optional<Compte> getCompteById(int id) {
        return compteRepository.findById(id);
    }

    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public Optional<Compte> updateCompte(int id, Compte compteDetails) {
        return compteRepository.findById(id).map(compte -> {
            compte.setNom(compteDetails.getNom()); 
            return compteRepository.save(compte);
        });
    }

    public boolean deleteCompte(int id) {
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
