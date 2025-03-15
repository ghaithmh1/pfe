package com.pfe.prj1.repository;

import com.pfe.prj1.model.PlanComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanComptableRepository extends JpaRepository<PlanComptable, Integer> {
}