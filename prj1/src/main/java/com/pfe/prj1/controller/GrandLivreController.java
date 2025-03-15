package com.pfe.prj1.controller;

import com.pfe.prj1.model.GrandLivre;
import com.pfe.prj1.repository.GrandLivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grand-livre")
public class GrandLivreController {

    @Autowired
    private GrandLivreRepository grandLivreRepository;

    @GetMapping
    public List<GrandLivre> getAllGrandLivres() {
        return grandLivreRepository.findAll();
    }

    @PostMapping
    public GrandLivre createGrandLivre(@RequestBody GrandLivre grandLivre) {
        return grandLivreRepository.save(grandLivre);
    }

    @GetMapping("/{id}")
    public GrandLivre getGrandLivreById(@PathVariable int id) {
        return grandLivreRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public GrandLivre updateGrandLivre(@PathVariable int id, @RequestBody GrandLivre grandLivreDetails) {
        GrandLivre grandLivre = grandLivreRepository.findById(id).orElse(null);
        if (grandLivre != null) {
            grandLivre.setSolde(grandLivreDetails.getSolde());
            return grandLivreRepository.save(grandLivre);
        }
        return null; 
    }

    @DeleteMapping("/{id}")
    public void deleteGrandLivre(@PathVariable int id) {
        grandLivreRepository.deleteById(id);
    }
}