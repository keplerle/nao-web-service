package com.kepler.repository;

import com.kepler.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {


}
