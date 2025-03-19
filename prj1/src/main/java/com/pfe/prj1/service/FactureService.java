package com.pfe.prj1.service;

import com.pfe.prj1.model.Facture;
import com.pfe.prj1.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }


    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    
    public Facture getFactureById(int id) {
        return factureRepository.findById(id).orElse(null);
    }


    public Facture updateFacture(int id, Facture factureDetails) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        if (optionalFacture.isPresent()) {
            Facture facture = optionalFacture.get();
            
            
            facture.setDateCreated(factureDetails.getDateCreated());
            facture.setDateUpdated(factureDetails.getDateUpdated());
            facture.setRibFacture(factureDetails.getRibFacture());
            facture.setAdresseClient(factureDetails.getAdresseClient());
            facture.setAdresseSociete(factureDetails.getAdresseSociete());
            facture.setBanque(factureDetails.getBanque());
            facture.setCodePostalClient(factureDetails.getCodePostalClient());
            facture.setCodePostalSociete(factureDetails.getCodePostalSociete());
            facture.setCommentaire(factureDetails.getCommentaire());
            facture.setCompteurFacture(factureDetails.getCompteurFacture());
            facture.setDateEmission(factureDetails.getDateEmission());
            facture.setDateEnvoiTTN(factureDetails.getDateEnvoiTTN());
            facture.setDateReglement(factureDetails.getDateReglement());
            facture.setDateSign(factureDetails.getDateSign());
            facture.setDateValid(factureDetails.getDateValid());
            facture.setDroitTimbre(factureDetails.getDroitTimbre());
            facture.setNumeroTTN(factureDetails.getNumeroTTN());
            facture.setEquivalentMontant(factureDetails.getEquivalentMontant());
            facture.setFactureOrig(factureDetails.getFactureOrig());
            facture.setFaxClient(factureDetails.getFaxClient());
            facture.setFaxSociete(factureDetails.getFaxSociete());
            facture.setFileImage(factureDetails.getFileImage());
            facture.setGeneratedRef(factureDetails.getGeneratedRef());
            facture.setLibelle(factureDetails.getLibelle());
            facture.setLibelleDevise(factureDetails.getLibelleDevise());
            facture.setMailClient(factureDetails.getMailClient());
            facture.setMailSociete(factureDetails.getMailSociete());
            facture.setMatriculeFiscaleClient(factureDetails.getMatriculeFiscaleClient());
            facture.setMatriculeFiscaleSociete(factureDetails.getMatriculeFiscaleSociete());
            facture.setModePaiement(factureDetails.getModePaiement());
            facture.setMontantLettre(factureDetails.getMontantLettre());
            facture.setMontantReglement(factureDetails.getMontantReglement());
            facture.setNumSerie(factureDetails.getNumSerie());
            facture.setNomClient(factureDetails.getNomClient());
            facture.setNomSociete(factureDetails.getNomSociete());
            facture.setNumBC(factureDetails.getNumBC());
            facture.setNumBL(factureDetails.getNumBL());
            facture.setNumFacture(factureDetails.getNumFacture());
            facture.setNumeroAvoir(factureDetails.getNumeroAvoir());
            facture.setNumeroCheque(factureDetails.getNumeroCheque());
            facture.setPaye(factureDetails.isPaye());
            facture.setPaysClient(factureDetails.getPaysClient());
            facture.setPaysClientId(factureDetails.getPaysClientId());
            facture.setPaysSociete(factureDetails.getPaysSociete());
            facture.setPaysSocieteId(factureDetails.getPaysSocieteId());
            facture.setPourcentage(factureDetails.getPourcentage());
            facture.setRefVirement(factureDetails.getRefVirement());
            facture.setReglementDiffere(factureDetails.isReglementDiffere());
            facture.setRemise(factureDetails.getRemise());
            facture.setResteAPayer(factureDetails.getResteAPayer());
            facture.setRetenueSourceCoche(factureDetails.isRetenueSourceCoche());
            facture.setRetenueSource(factureDetails.getRetenueSource());
            facture.setRueClient(factureDetails.getRueClient());
            facture.setRueSociete(factureDetails.getRueSociete());
            facture.setSendTTN(factureDetails.isSendTTN());
            facture.setTauxDeviseChoisi(factureDetails.getTauxDeviseChoisi());
            facture.setTaxeParafiscale(factureDetails.getTaxeParafiscale());
            facture.setTelClient(factureDetails.getTelClient());
            facture.setTelSociete(factureDetails.getTelSociete());
            facture.setTotalHT(factureDetails.getTotalHT());
            facture.setTotalHTVA(factureDetails.getTotalHTVA());
            facture.setTotalTTC(factureDetails.getTotalTTC());
            facture.setTotalTVA(factureDetails.getTotalTVA());
            facture.setTvaExonere(factureDetails.getTvaExonere());
            facture.setUnifiedHTVA(factureDetails.getUnifiedHTVA());
            facture.setUnifiedTTC(factureDetails.getUnifiedTTC());
            facture.setValide(factureDetails.isValide());
            facture.setVilleClient(factureDetails.getVilleClient());
            facture.setVilleSociete(factureDetails.getVilleSociete());
            facture.setClientId(factureDetails.getClientId());
            facture.setDevise(factureDetails.getDevise());
            facture.setMagasinId(factureDetails.getMagasinId());
            facture.setSignedFileShadocId(factureDetails.getSignedFileShadocId());

            return factureRepository.save(facture);
        }
        return null;
    }


    public void deleteFacture(int id) {
        factureRepository.deleteById(id);
    }
}
