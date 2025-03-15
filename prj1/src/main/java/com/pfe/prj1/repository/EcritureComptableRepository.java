package com.pfe.prj1.repository;

import com.pfe.prj1.model.EcritureComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcritureComptableRepository extends JpaRepository<EcritureComptable, Integer> {
}