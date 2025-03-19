package com.pfe.prj1.controller;

import com.pfe.prj1.model.GrandLivre;
import com.pfe.prj1.service.GrandLivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grand-livre")
public class GrandLivreController {

    @Autowired
    private GrandLivreService grandLivreService;

    @GetMapping
    public List<GrandLivre> getAllGrandLivres() {
        return grandLivreService.getAllGrandLivres();
    }

    @PostMapping
    public GrandLivre createGrandLivre(@RequestBody GrandLivre grandLivre) {
        return grandLivreService.createGrandLivre(grandLivre);
    }


    @GetMapping("/{id}")
    public GrandLivre getGrandLivreById(@PathVariable int id) {
        return grandLivreService.getGrandLivreById(id);}

    @PutMapping("/{id}")
    public GrandLivre updateGrandLivre(@PathVariable int id, @RequestBody GrandLivre grandLivreDetails) {
        return grandLivreService.updateGrandLivre(id, grandLivreDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteGrandLivre(@PathVariable int id) {
        grandLivreService.deleteGrandLivre(id);
    }
}
