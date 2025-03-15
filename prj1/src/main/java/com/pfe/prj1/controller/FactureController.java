package com.pfe.prj1.controller;

import com.pfe.prj1.model.Facture;
import com.pfe.prj1.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @PostMapping
    public Facture createFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable int id) {
        return factureRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable int id, @RequestBody Facture factureDetails) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        if (optionalFacture.isPresent()) {
            Facture facture = optionalFacture.get();
            facture.setDateCreated(factureDetails.getDateCreated());
            facture.setDateUpdated(factureDetails.getDateUpdated());
            facture.setVersion(factureDetails.getVersion());
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

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable int id) {
        factureRepository.deleteById(id);
    }
}
