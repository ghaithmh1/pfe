package com.pfe.prj1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class FactureArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_updated")
    private Date dateUpdated;

    @Version
    private int version;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "commentaire", length = 255)
    private String commentaire;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "montant_itc")
    private int montantITC;

    @Column(name = "montant_tva")
    private int montantTVA;

    @Column(name = "nbr_apres_virgule")
    private int nbrApresVirgule;

    @Column(name = "num_bl_converted", length = 100)
    private String numBLConverted;

    @Column(name = "order_by")
    private int orderBy;

    @Column(name = "prix_unitaire")
    private int prixUnitaire;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "remise")
    private int remise;

    @Column(name = "total_ht")
    private int totalHT;

    @Column(name = "article")
    private int article;

    @ManyToOne
    @JoinColumn(name = "facture_id", referencedColumnName = "id")
    private Facture facture;

    @Column(name = "tva")
    private int tva;

    @Column(name = "code_barre", length = 100)
    private String codeBarre;
}
