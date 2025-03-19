package com.pfe.prj1.service;

import com.pfe.prj1.model.PlanComptable;
import com.pfe.prj1.repository.PlanComptableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanComptableService {

    @Autowired
    private PlanComptableRepository planComptableRepository;

    public List<PlanComptable> getAllPlanComptables() {
        return planComptableRepository.findAll();
    }

    public PlanComptable createPlanComptable(PlanComptable planComptable) {
        return planComptableRepository.save(planComptable);
    }

    public Optional<PlanComptable> getPlanComptableById(int id) {
        return planComptableRepository.findById(id);
    }

    public PlanComptable updatePlanComptable(int id, PlanComptable planComptableDetails) {
        Optional<PlanComptable> existingPlanComptable = planComptableRepository.findById(id);
        if (existingPlanComptable.isPresent()) {
            PlanComptable planComptable = existingPlanComptable.get();
            planComptable.setNom(planComptableDetails.getNom());
            return planComptableRepository.save(planComptable);
        }
        return null;
    }

    public void deletePlanComptable(int id) {
        planComptableRepository.deleteById(id);
    }
}
