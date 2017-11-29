package com.kepler.service;


import com.kepler.model.Prof;
import com.kepler.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DefaultProfService implements ProfService{

        @Autowired
        private ProfRepository profRepository;

        @Override
        public Prof save(Prof entity) {
            return profRepository.save(entity);
        }

        @Override
        public Prof getById(Serializable id) {
            return profRepository.findOne((Long) id);
        }

        @Override
        public List<Prof> getAll() {
            return profRepository.findAll();
        }

        @Override
        public void delete(Serializable id) {  profRepository.delete((Long) id);
        }
}
