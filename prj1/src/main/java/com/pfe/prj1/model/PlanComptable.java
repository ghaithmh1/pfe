package com.pfe.prj1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "plan_comptable")
public class PlanComptable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Le nom du plan comptable ne peut pas être vide")
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @OneToMany(mappedBy = "planComptable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classe> classes;


    // Constructeurs
    public PlanComptable() {}

    public PlanComptable(String nom) {
        this.nom = nom;
    }
}