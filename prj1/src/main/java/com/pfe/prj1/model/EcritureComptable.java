package com.pfe.prj1.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ecriture_comptable")
public class EcritureComptable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "num", nullable = false)
    private int num;

    @Column(name = "reference", nullable = false, length = 100)
    private String reference;

    @Column(name = "statut", nullable = false, length = 50)
    private String statut;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "montant", nullable = false)
    private float montant;

    @OneToMany(mappedBy = "ecritureComptable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<rl_Compte_Ecriture> relations;

    // Constructeurs
    public EcritureComptable() {}

    public EcritureComptable(int num, String reference, String statut, Date date, float montant) {
        this.num = num;
        this.reference = reference;
        this.statut = statut;
        this.date = date;
        this.montant = montant;
    }
}