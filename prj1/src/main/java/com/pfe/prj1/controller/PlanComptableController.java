package com.pfe.prj1.controller;

import com.pfe.prj1.model.PlanComptable;
import com.pfe.prj1.repository.PlanComptableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan-comptable")
public class PlanComptableController {

    @Autowired
    private PlanComptableRepository planComptableRepository;

    @GetMapping
    public List<PlanComptable> getAllPlanComptables() {
        return planComptableRepository.findAll();
    }

    @PostMapping
    public PlanComptable createPlanComptable(@RequestBody PlanComptable planComptable) {
        return planComptableRepository.save(planComptable);
    }

    @GetMapping("/{id}")
    public PlanComptable getPlanComptableById(@PathVariable int id) {
        return planComptableRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PlanComptable updatePlanComptable(@PathVariable int id, @RequestBody PlanComptable planComptableDetails) {
        PlanComptable planComptable = planComptableRepository.findById(id).orElse(null);
        if (planComptable != null) {
            planComptable.setNom(planComptableDetails.getNom());
            return planComptableRepository.save(planComptable);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePlanComptable(@PathVariable int id) {
        planComptableRepository.deleteById(id);
    }
}