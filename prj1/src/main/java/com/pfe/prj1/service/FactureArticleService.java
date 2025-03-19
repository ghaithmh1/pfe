package com.pfe.prj1.service;

import com.pfe.prj1.model.FactureArticle;
import com.pfe.prj1.repository.FactureArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureArticleService {

    @Autowired
    private FactureArticleRepository factureArticleRepository;

    public List<FactureArticle> getAllFactureArticles() {
        return factureArticleRepository.findAll();
    }

    public Optional<FactureArticle> getFactureArticleById(int id) {
        return factureArticleRepository.findById(id);
    }

    public FactureArticle createFactureArticle(FactureArticle factureArticle) {
        return factureArticleRepository.save(factureArticle);
    }

    public Optional<FactureArticle> updateFactureArticle(int id, FactureArticle factureArticleDetails) {
        Optional<FactureArticle> existingFactureArticle = factureArticleRepository.findById(id);
        
        if (existingFactureArticle.isPresent()) {
            FactureArticle factureArticle = existingFactureArticle.get();
            
            factureArticle.setDateCreated(factureArticleDetails.getDateCreated());
            factureArticle.setDateUpdated(factureArticleDetails.getDateUpdated());
            factureArticle.setCode(factureArticleDetails.getCode());
            factureArticle.setCommentaire(factureArticleDetails.getCommentaire());
            factureArticle.setDescription(factureArticleDetails.getDescription());
            factureArticle.setDesignation(factureArticleDetails.getDesignation());
            factureArticle.setMontantITC(factureArticleDetails.getMontantITC());
            factureArticle.setMontantTVA(factureArticleDetails.getMontantTVA());
            factureArticle.setNbrApresVirgule(factureArticleDetails.getNbrApresVirgule());
            factureArticle.setNumBLConverted(factureArticleDetails.getNumBLConverted());
            factureArticle.setOrderBy(factureArticleDetails.getOrderBy());
            factureArticle.setPrixUnitaire(factureArticleDetails.getPrixUnitaire());
            factureArticle.setQuantite(factureArticleDetails.getQuantite());
            factureArticle.setRemise(factureArticleDetails.getRemise());
            factureArticle.setTotalHT(factureArticleDetails.getTotalHT());
            factureArticle.setArticle(factureArticleDetails.getArticle());
            factureArticle.setFacture(factureArticleDetails.getFacture());
            factureArticle.setTva(factureArticleDetails.getTva());
            factureArticle.setCodeBarre(factureArticleDetails.getCodeBarre());

            return Optional.of(factureArticleRepository.save(factureArticle));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteFactureArticle(int id) {
        Optional<FactureArticle> factureArticle = factureArticleRepository.findById(id);
        if (factureArticle.isPresent()) {
            factureArticleRepository.delete(factureArticle.get());
            return true;
        } else {
            return false;
        }
    }
}
