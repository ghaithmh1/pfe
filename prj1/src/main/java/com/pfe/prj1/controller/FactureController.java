package com.pfe.prj1.controller;

import com.pfe.prj1.model.Facture;
import com.pfe.prj1.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }

    @PostMapping
    public Facture createFacture(@RequestBody Facture facture) {
        return factureService.createFacture(facture);
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable int id) {
        return factureService.getFactureById(id);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable int id, @RequestBody Facture factureDetails) {
        return factureService.updateFacture(id, factureDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable int id) {
        factureService.deleteFacture(id);
    }
}
