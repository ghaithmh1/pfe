package com.pfe.prj1.controller;

import com.pfe.prj1.model.EcritureComptable;
import com.pfe.prj1.repository.EcritureComptableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecriture-comptable")
public class EcritureComptableController {

    @Autowired
    private EcritureComptableRepository ecritureComptableRepository;

    @GetMapping
    public List<EcritureComptable> getAllEcrituresComptables() {
        return ecritureComptableRepository.findAll();
    }

    @PostMapping
    public EcritureComptable createEcritureComptable(@RequestBody EcritureComptable ecritureComptable) {
        return ecritureComptableRepository.save(ecritureComptable);
    }

    @GetMapping("/{id}")
    public EcritureComptable getEcritureComptableById(@PathVariable int id) {
        return ecritureComptableRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public EcritureComptable updateEcritureComptable(@PathVariable int id, @RequestBody EcritureComptable ecritureComptableDetails) {
        EcritureComptable ecritureComptable = ecritureComptableRepository.findById(id).orElse(null);
        if (ecritureComptable != null) {
            ecritureComptable.setNum(ecritureComptableDetails.getNum());
            ecritureComptable.setReference(ecritureComptableDetails.getReference());
            ecritureComptable.setStatut(ecritureComptableDetails.getStatut());
            ecritureComptable.setDate(ecritureComptableDetails.getDate());
            ecritureComptable.setMontant(ecritureComptableDetails.getMontant());
            return ecritureComptableRepository.save(ecritureComptable);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEcritureComptable(@PathVariable int id) {
        ecritureComptableRepository.deleteById(id);
    }
}