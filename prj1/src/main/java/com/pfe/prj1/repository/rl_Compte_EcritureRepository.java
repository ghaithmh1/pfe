package com.pfe.prj1.repository;

import com.pfe.prj1.model.rl_Compte_Ecriture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rl_Compte_EcritureRepository extends JpaRepository<rl_Compte_Ecriture, Integer> {
}