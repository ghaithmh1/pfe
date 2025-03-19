package com.pfe.prj1.controller;

import com.pfe.prj1.model.Compte;
import com.pfe.prj1.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping
    public ResponseEntity<List<Compte>> getAllComptes() {
        return ResponseEntity.ok(compteService.getAllComptes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable int id) {
        Optional<Compte> compte = compteService.getCompteById(id);
        return compte.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        return ResponseEntity.ok(compteService.createCompte(compte));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compte> updateCompte(@PathVariable int id, @RequestBody Compte compteDetails) {
        Optional<Compte> updatedCompte = compteService.updateCompte(id, compteDetails);
        return updatedCompte.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable int id) {
        if (compteService.deleteCompte(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
