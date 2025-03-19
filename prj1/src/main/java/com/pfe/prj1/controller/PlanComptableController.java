package com.pfe.prj1.controller;

import com.pfe.prj1.model.PlanComptable;
import com.pfe.prj1.service.PlanComptableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan-comptable")
public class PlanComptableController {

    @Autowired
    private PlanComptableService planComptableService;

    @GetMapping
    public List<PlanComptable> getAllPlanComptables() {
        return planComptableService.getAllPlanComptables();
    }

    @PostMapping
    public PlanComptable createPlanComptable(@RequestBody PlanComptable planComptable) {
        return planComptableService.createPlanComptable(planComptable);
    }

    @GetMapping("/{id}")
    public PlanComptable getPlanComptableById(@PathVariable int id) {
        return planComptableService.getPlanComptableById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PlanComptable updatePlanComptable(@PathVariable int id, @RequestBody PlanComptable planComptableDetails) {
        return planComptableService.updatePlanComptable(id, planComptableDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePlanComptable(@PathVariable int id) {
        planComptableService.deletePlanComptable(id);
    }
}
