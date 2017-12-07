package com.kepler.service;

import com.kepler.model.Eleve;

import java.util.List;

public interface EleveService extends CRUDService<Eleve> {

    List<Eleve> findByProf(String prof);
}
