package com.kepler.service;

import com.kepler.model.Person;
public interface PersonService extends CRUDService {

    //Gestion des (transactions) et validation
    //-> controller communication client-service) -> Service validation & transaction (à checker rollback commit) -> Dao (INSERT/ SELECT/ UPDATE/ DELETE)
}
