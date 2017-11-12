package com.kepler.service;


import com.kepler.model.Eleve;
import com.kepler.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DefaultEleveService implements EleveService{

        @Autowired
        private EleveRepository eleveRepository;

        @Override
        public Eleve save(Eleve entity) {
            return eleveRepository.save(entity);
        }

        @Override
        public Eleve getById(Serializable id) {
            return eleveRepository.findOne((Long) id);
        }

        @Override
        public List<Eleve> getAll() {
            return eleveRepository.findAll();
        }

        @Override
        public void delete(Serializable id) {
            eleveRepository.delete((Long) id);
        }
}
