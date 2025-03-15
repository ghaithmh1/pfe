package com.pfe.prj1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Le nom du compte ne peut pas être vide")
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Compte parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compte> subCodes;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    // Constructeurs
    public Compte() {}

    public Compte(String nom) {
        this.nom = nom;
    }
}