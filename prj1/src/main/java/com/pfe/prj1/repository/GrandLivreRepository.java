package com.pfe.prj1.repository;

import com.pfe.prj1.model.GrandLivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandLivreRepository extends JpaRepository<GrandLivre, Integer> {
}