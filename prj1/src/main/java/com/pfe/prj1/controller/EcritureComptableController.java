package com.pfe.prj1.controller;

import com.pfe.prj1.model.EcritureComptable;
import com.pfe.prj1.service.EcritureComptableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ecriture-comptable")
public class EcritureComptableController {

    @Autowired
    private EcritureComptableService ecritureComptableService;

    @GetMapping
    public List<EcritureComptable> getAllEcrituresComptables() {
        return ecritureComptableService.getAllEcrituresComptables();
    }

    @GetMapping("/{id}")
    public Optional<EcritureComptable> getEcritureComptableById(@PathVariable int id) {
        return ecritureComptableService.getEcritureComptableById(id);
    }

    @PostMapping
    public EcritureComptable createEcritureComptable(@RequestBody EcritureComptable ecritureComptable) {
        return ecritureComptableService.createEcritureComptable(ecritureComptable);
    }

    @PutMapping("/{id}")
    public EcritureComptable updateEcritureComptable(@PathVariable int id, @RequestBody EcritureComptable ecritureComptableDetails) {
        return ecritureComptableService.updateEcritureComptable(id, ecritureComptableDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEcritureComptable(@PathVariable int id) {
        ecritureComptableService.deleteEcritureComptable(id);
    }
}
