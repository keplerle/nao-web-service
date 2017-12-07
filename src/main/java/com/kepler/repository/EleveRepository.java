package com.kepler.repository;

import com.kepler.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, String> {
    List<Eleve> findByProf(String prof);

}
