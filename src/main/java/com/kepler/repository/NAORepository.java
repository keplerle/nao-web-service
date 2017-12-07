package com.kepler.repository;

import com.kepler.model.NAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NAORepository extends JpaRepository<NAO, String> {
    List<NAO> findByMailprof(String mail);


}
