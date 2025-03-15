package com.pfe.prj1.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "grand_livre")
public class GrandLivre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "solde", nullable = false)
    private float solde;

    @OneToMany(mappedBy = "grandLivre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<rl_Compte_Ecriture> relations;

    // Constructeurs
    public GrandLivre() {}

    public GrandLivre(float solde) {
        this.solde = solde;
    }
}