package com.pfe.prj1.controller;

import com.pfe.prj1.model.Reglement;
import com.pfe.prj1.repository.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reglements")
public class ReglementController {

    @Autowired
    private ReglementRepository reglementRepository;

    // Get all reglements
    @GetMapping
    public List<Reglement> getAllReglements() {
        return reglementRepository.findAll();
    }

    // Get a single reglement by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reglement> getReglementById(@PathVariable int id) {
        Optional<Reglement> reglement = reglementRepository.findById(id);
        if (reglement.isPresent()) {
            return new ResponseEntity<>(reglement.get(), HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    // Create a new reglement
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reglement createReglement(@RequestBody Reglement reglement) {
        return reglementRepository.save(reglement);
    }

    // Update an existing reglement
    @PutMapping("/{id}")
    public ResponseEntity<Reglement> updateReglement(@PathVariable int id, @RequestBody Reglement reglementDetails) {
        Optional<Reglement> existingReglement = reglementRepository.findById(id);
        
        if (existingReglement.isPresent()) {
            Reglement reglement = existingReglement.get();
            
            reglement.setDateReglement(reglementDetails.getDateReglement());
            reglement.setModePaiement(reglementDetails.getModePaiement());
            reglement.setMontant(reglementDetails.getMontant());
            reglement.setNumeroAvoir(reglementDetails.getNumeroAvoir());
            reglement.setNumeroCheque(reglementDetails.getNumeroCheque());
            reglement.setRefVirement(reglementDetails.getRefVirement());
            reglement.setFacture(reglementDetails.getFacture());
            reglement.setReglementFacture(reglementDetails.isReglementFacture());
            reglement.setBanqueNom(reglementDetails.getBanqueNom());

            Reglement updatedReglement = reglementRepository.save(reglement);
            return new ResponseEntity<>(updatedReglement, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    // Delete a reglement by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteReglement(@PathVariable int id) {
        Optional<Reglement> reglement = reglementRepository.findById(id);
        
        if (reglement.isPresent()) {
            reglementRepository.delete(reglement.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
}
