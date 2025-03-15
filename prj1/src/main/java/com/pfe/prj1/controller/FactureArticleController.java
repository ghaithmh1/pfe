package com.pfe.prj1.controller;

import com.pfe.prj1.model.FactureArticle;
import com.pfe.prj1.repository.FactureArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturearticles")
public class FactureArticleController {

    @Autowired
    private FactureArticleRepository factureArticleRepository;

    @GetMapping
    public List<FactureArticle> getAllFactureArticles() {
        return factureArticleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureArticle> getFactureArticleById(@PathVariable int id) {
        Optional<FactureArticle> factureArticle = factureArticleRepository.findById(id);
        if (factureArticle.isPresent()) {
            return new ResponseEntity<>(factureArticle.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    
    @PostMapping
    public ResponseEntity<FactureArticle> createFactureArticle(@RequestBody FactureArticle factureArticle) {
        FactureArticle savedFactureArticle = factureArticleRepository.save(factureArticle);
        return new ResponseEntity<>(savedFactureArticle, HttpStatus.CREATED); 
    }


    @PutMapping("/{id}")
    public ResponseEntity<FactureArticle> updateFactureArticle(@PathVariable int id, @RequestBody FactureArticle factureArticleDetails) {
        Optional<FactureArticle> existingFactureArticle = factureArticleRepository.findById(id);
        
        if (existingFactureArticle.isPresent()) {
            FactureArticle factureArticle = existingFactureArticle.get();
            
        
            factureArticle.setDateCreated(factureArticleDetails.getDateCreated());
            factureArticle.setDateUpdated(factureArticleDetails.getDateUpdated());
            factureArticle.setCode(factureArticleDetails.getCode());
            factureArticle.setCommentaire(factureArticleDetails.getCommentaire());
            factureArticle.setDescription(factureArticleDetails.getDescription());
            factureArticle.setDesignation(factureArticleDetails.getDesignation());
            factureArticle.setMontantITC(factureArticleDetails.getMontantITC());
            factureArticle.setMontantTVA(factureArticleDetails.getMontantTVA());
            factureArticle.setNbrApresVirgule(factureArticleDetails.getNbrApresVirgule());
            factureArticle.setNumBLConverted(factureArticleDetails.getNumBLConverted());
            factureArticle.setOrderBy(factureArticleDetails.getOrderBy());
            factureArticle.setPrixUnitaire(factureArticleDetails.getPrixUnitaire());
            factureArticle.setQuantite(factureArticleDetails.getQuantite());
            factureArticle.setRemise(factureArticleDetails.getRemise());
            factureArticle.setTotalHT(factureArticleDetails.getTotalHT());
            factureArticle.setArticle(factureArticleDetails.getArticle());
            factureArticle.setFacture(factureArticleDetails.getFacture());
            factureArticle.setTva(factureArticleDetails.getTva());
            factureArticle.setCodeBarre(factureArticleDetails.getCodeBarre());

            FactureArticle updatedFactureArticle = factureArticleRepository.save(factureArticle);
            return new ResponseEntity<>(updatedFactureArticle, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    // Delete a facture article by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactureArticle(@PathVariable int id) {
        Optional<FactureArticle> factureArticle = factureArticleRepository.findById(id);

        if (factureArticle.isPresent()) {
            factureArticleRepository.delete(factureArticle.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
}
