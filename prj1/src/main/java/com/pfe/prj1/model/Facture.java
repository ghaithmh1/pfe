package com.pfe.prj1.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;
    
    @Column(name = "date_updated")
    private Date dateUpdated;
    
    @Version
    private int version;
    
    @Column(name = "rib_facture", length = 100)
    private String ribFacture;
    
    @Column(name = "adresse_client")
    private String adresseClient;
    
    @Column(name = "adresse_societe")
    private String adresseSociete;
    
    @Column(name = "banque")
    private String banque;
    
    @Column(name = "code_postal_client")
    private String codePostalClient;
    
    @Column(name = "code_postal_societe")
    private String codePostalSociete;
    
    @Column(name = "commentaire")
    private String commentaire;
    
    @Column(name = "compteur_facture")
    private int compteurFacture;
    
    @Column(name = "date_emission")
    private Date dateEmission;
    
    @Column(name = "date_envoi_ttn")
    private Date dateEnvoiTTN;
    
    @Column(name = "date_reglement")
    private Date dateReglement;
    
    @Column(name = "date_sign")
    private Date dateSign;
    
    @Column(name = "date_valid")
    private Date dateValid;
    
    @Column(name = "droit_timbre")
    private int droitTimbre;
    
    @Column(name = "numero_ttn")
    private String numeroTTN;
    
    @Column(name = "equivalent_montant")
    private int equivalentMontant;
    
    @Column(name = "facture_orig")
    private int factureOrig;
    
    @Column(name = "fax_client")
    private String faxClient;
    
    @Column(name = "fax_societe")
    private String faxSociete;
    
    @Column(name = "file_image")
    private String fileImage;
    
    @Column(name = "generated_ref")
    private String generatedRef;
    
    @Column(name = "libelle")
    private String libelle;
    
    @Column(name = "libelle_devise")
    private String libelleDevise;
    
    @Column(name = "mail_client")
    private String mailClient;
    
    @Column(name = "mail_societe")
    private String mailSociete;
    
    @Column(name = "matricule_fiscale_client")
    private String matriculeFiscaleClient;
    
    @Column(name = "matricule_fiscale_societe")
    private String matriculeFiscaleSociete;
    
    @Column(name = "mode_paiement")
    private String modePaiement;
    
    @Column(name = "montant_lettre")
    private int montantLettre;
    
    @Column(name = "montant_reglement")
    private int montantReglement;
    
    @Column(name = "num_serie")
    private String numSerie;
    
    @Column(name = "nom_client")
    private String nomClient;
    
    @Column(name = "nom_societe")
    private String nomSociete;
    
    @Column(name = "num_bc")
    private String numBC;
    
    @Column(name = "num_bl")
    private String numBL;
    
    @Column(name = "num_facture")
    private String numFacture;
    
    @Column(name = "numero_avoir")
    private String numeroAvoir;
    
    @Column(name = "numero_cheque")
    private String numeroCheque;
    
    @Column(name = "paye")
    private boolean paye;
    
    @Column(name = "pays_client")
    private String paysClient;
    
    @Column(name = "pays_client_id")
    private int paysClientId;
    
    @Column(name = "pays_societe")
    private String paysSociete;
    
    @Column(name = "pays_societe_id")
    private int paysSocieteId;
    
    @Column(name = "pourcentage")
    private int pourcentage;
    
    @Column(name = "ref_virement")
    private String refVirement;
    
    @Column(name = "reglement_differe")
    private boolean reglementDiffere;
    
    @Column(name = "remise")
    private double remise;
    
    @Column(name = "reste_a_payer")
    private int resteAPayer;
    
    @Column(name = "retenue_source_coche")
    private boolean retenueSourceCoche;
    
    @Column(name = "retenue_source")
    private int retenueSource;
    
    @Column(name = "rue_client")
    private String rueClient;
    
    @Column(name = "rue_societe")
    private String rueSociete;
    
    @Column(name = "send_ttn")
    private boolean sendTTN;
    
    @Column(name = "taux_devise_choisi")
    private int tauxDeviseChoisi;
    
    @Column(name = "taxe_parafiscale")
    private int taxeParafiscale;
    
    @Column(name = "tel_client")
    private String telClient;
    
    @Column(name = "tel_societe")
    private String telSociete;
    
    @Column(name = "total_ht")
    private int totalHT;
    
    @Column(name = "total_htva")
    private int totalHTVA;
    
    @Column(name = "total_ttc")
    private int totalTTC;
    
    @Column(name = "total_tva")
    private int totalTVA;
    
    @Column(name = "tva_exonere")
    private int tvaExonere;
    
    @Column(name = "unified_htva")
    private int unifiedHTVA;
    
    @Column(name = "unified_ttc")
    private int unifiedTTC;
    
    @Column(name = "valide")
    private boolean valide;
    
    @Column(name = "ville_client")
    private String villeClient;
    
    @Column(name = "ville_societe")
    private String villeSociete;
    
    @Column(name = "client_id")
    private int clientId;
    
    @Column(name = "devise")
    private String devise;
    
    @Column(name = "magasin_id")
    private int magasinId;
    
    @Column(name = "signed_file_shadoc_id")
    private int signedFileShadocId;
}