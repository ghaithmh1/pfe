package com.pfe.prj1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Le nom de la classe ne peut pas être vide")
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "plan_comptable_id")
    private PlanComptable planComptable;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compte> comptes;

    
    // Constructeurs
    public Classe() {}

    public Classe(String nom) {
        this.nom = nom;
    }
}