package com.pfe.prj1.controller;

import com.pfe.prj1.model.Classe;
import com.pfe.prj1.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @PostMapping
    public Classe createClasse(@RequestBody Classe classe) {
        return classeRepository.save(classe);
    }

    @GetMapping("/{id}")
    public Classe getClasseById(@PathVariable int id) {
        return classeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Classe updateClasse(@PathVariable int id, @RequestBody Classe classeDetails) {
        Classe classe = classeRepository.findById(id).orElse(null);
        if (classe != null) {
            classe.setNom(classeDetails.getNom());
            return classeRepository.save(classe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteClasse(@PathVariable int id) {
        classeRepository.deleteById(id);
    }
}