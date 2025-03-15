package com.pfe.prj1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rl_compte_ecriture")
public class rl_Compte_Ecriture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "credit", nullable = false)
    private float credit;

    @Column(name = "debit", nullable = false)
    private float debit;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "ecriture_comptable_id")
    private EcritureComptable ecritureComptable;

    @ManyToOne
    @JoinColumn(name = "grand_livre_id")
    private GrandLivre grandLivre;
    
    // Constructeurs
    public rl_Compte_Ecriture() {}

    public rl_Compte_Ecriture(String description, float credit, float debit) {
        this.description = description;
        this.credit = credit;
        this.debit = debit;
    }
}