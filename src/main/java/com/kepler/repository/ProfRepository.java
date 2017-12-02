package com.kepler.repository;

import com.kepler.model.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfRepository extends JpaRepository<Prof, String> {

    Prof findByMail(String mail);
}
