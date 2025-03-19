package com.pfe.prj1.service;

import com.pfe.prj1.model.Classe;
import com.pfe.prj1.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public Optional<Classe> getClasseById(int id) {
        return classeRepository.findById(id);
    }

    public Classe createClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public Optional<Classe> updateClasse(int id, Classe classeDetails) {
        return classeRepository.findById(id).map(classe -> {
            classe.setNom(classeDetails.getNom());
            return classeRepository.save(classe);
        });
    }

    public boolean deleteClasse(int id) {
        if (classeRepository.existsById(id)) {
            classeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
