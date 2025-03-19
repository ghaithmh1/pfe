package com.pfe.prj1.controller;

import com.pfe.prj1.model.FactureArticle;
import com.pfe.prj1.service.FactureArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturearticles")
public class FactureArticleController {

    @Autowired
    private FactureArticleService factureArticleService;

    @GetMapping
    public List<FactureArticle> getAllFactureArticles() {
        return factureArticleService.getAllFactureArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureArticle> getFactureArticleById(@PathVariable int id) {
        Optional<FactureArticle> factureArticle = factureArticleService.getFactureArticleById(id);
        if (factureArticle.isPresent()) {
            return new ResponseEntity<>(factureArticle.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @PostMapping
    public ResponseEntity<FactureArticle> createFactureArticle(@RequestBody FactureArticle factureArticle) {
        FactureArticle savedFactureArticle = factureArticleService.createFactureArticle(factureArticle);
        return new ResponseEntity<>(savedFactureArticle, HttpStatus.CREATED); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactureArticle> updateFactureArticle(@PathVariable int id, @RequestBody FactureArticle factureArticleDetails) {
        Optional<FactureArticle> updatedFactureArticle = factureArticleService.updateFactureArticle(id, factureArticleDetails);
        
        if (updatedFactureArticle.isPresent()) {
            return new ResponseEntity<>(updatedFactureArticle.get(), HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactureArticle(@PathVariable int id) {
        boolean isDeleted = factureArticleService.deleteFactureArticle(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
}
