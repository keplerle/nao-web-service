package com.kepler.repository;

import com.kepler.model.NAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NAORepository extends JpaRepository<NAO, Long> {


}
