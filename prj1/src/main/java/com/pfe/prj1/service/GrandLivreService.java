package com.pfe.prj1.service;

import com.pfe.prj1.model.GrandLivre;
import com.pfe.prj1.repository.GrandLivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrandLivreService {

    @Autowired
    private GrandLivreRepository grandLivreRepository;

    public List<GrandLivre> getAllGrandLivres() {
        return grandLivreRepository.findAll();
    }

    public GrandLivre createGrandLivre(GrandLivre grandLivre) {
        return grandLivreRepository.save(grandLivre);
    }

    public GrandLivre getGrandLivreById(int id) {
        Optional<GrandLivre> grandLivre = grandLivreRepository.findById(id);
        return grandLivre.orElse(null); 
    }

    public GrandLivre updateGrandLivre(int id, GrandLivre grandLivreDetails) {
        Optional<GrandLivre> grandLivreOptional = grandLivreRepository.findById(id);
        if (grandLivreOptional.isPresent()) {
            GrandLivre grandLivre = grandLivreOptional.get();
            grandLivre.setSolde(grandLivreDetails.getSolde());
            return grandLivreRepository.save(grandLivre);
        }
        return null;
    }

    public void deleteGrandLivre(int id) {
        grandLivreRepository.deleteById(id);
    }
}
