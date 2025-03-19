package com.pfe.prj1.service;

import com.pfe.prj1.model.EcritureComptable;
import com.pfe.prj1.repository.EcritureComptableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EcritureComptableService {

    @Autowired
    private EcritureComptableRepository ecritureComptableRepository;

    public List<EcritureComptable> getAllEcrituresComptables() {
        return ecritureComptableRepository.findAll();
    }

    public Optional<EcritureComptable> getEcritureComptableById(int id) {
        return ecritureComptableRepository.findById(id);
    }

    public EcritureComptable createEcritureComptable(EcritureComptable ecritureComptable) {
        return ecritureComptableRepository.save(ecritureComptable);
    }

    public EcritureComptable updateEcritureComptable(int id, EcritureComptable ecritureComptableDetails) {
        return ecritureComptableRepository.findById(id).map(ecriture -> {
            ecriture.setNum(ecritureComptableDetails.getNum());
            ecriture.setReference(ecritureComptableDetails.getReference());
            ecriture.setStatut(ecritureComptableDetails.getStatut());
            ecriture.setDate(ecritureComptableDetails.getDate());
            ecriture.setMontant(ecritureComptableDetails.getMontant());
            return ecritureComptableRepository.save(ecriture);
        }).orElse(null);
    }

    public void deleteEcritureComptable(int id) {
        ecritureComptableRepository.deleteById(id);
    }
}
