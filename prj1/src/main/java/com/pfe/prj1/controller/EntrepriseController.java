package com.pfe.prj1.controller;

import com.pfe.prj1.model.Entreprise;
import com.pfe.prj1.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @GetMapping
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @PostMapping
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
        entreprise.setUuid(UUID.randomUUID().toString());
        entreprise.setDateCreated(new Date());
        entreprise.setDateUpdated(new Date());
        entreprise.setVersion(1);
        return entrepriseRepository.save(entreprise);
    }

    @GetMapping("/{id}")
    public Entreprise getEntrepriseById(@PathVariable int id) {
        return entrepriseRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Entreprise updateEntreprise(@PathVariable int id, @RequestBody Entreprise entrepriseDetails) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);
        if (entreprise != null) {
            entreprise.setNom(entrepriseDetails.getNom());
            entreprise.setAdresse(entrepriseDetails.getAdresse());
            entreprise.setCodePostal(entrepriseDetails.getCodePostal());
            entreprise.setFax(entrepriseDetails.getFax());
            entreprise.setMail(entrepriseDetails.getMail());
            entreprise.setMatriculeFiscale(entrepriseDetails.getMatriculeFiscale());
            entreprise.setPays(entrepriseDetails.getPays());
            entreprise.setTel(entrepriseDetails.getTel());
            entreprise.setVille(entrepriseDetails.getVille());
            entreprise.setDevise(entrepriseDetails.getDevise());
            entreprise.setIdPays(entrepriseDetails.getIdPays());
            entreprise.setDateUpdated(new Date());
            return entrepriseRepository.save(entreprise);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEntreprise(@PathVariable int id) {
        entrepriseRepository.deleteById(id);
    }
}