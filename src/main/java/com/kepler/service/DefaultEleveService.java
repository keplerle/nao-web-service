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
    public Eleve getBy(String prof) {
        return eleveRepository.findOne(prof);
    }


       /* @Override
        public List<Eleve> getAllByString(Iterable<String> strings) {
            return eleveRepository.findAll(strings);
        }
*/
    @Override
    public void delete(String prof) {
        eleveRepository.delete(prof);
    }
}
