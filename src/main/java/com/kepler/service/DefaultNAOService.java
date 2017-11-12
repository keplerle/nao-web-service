package com.kepler.service;


import com.kepler.model.NAO;
import com.kepler.repository.NAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DefaultNAOService implements NAOService{

        @Autowired
        private NAORepository naoRepository;

        @Override
        public NAO save(NAO entity) {
            return naoRepository.save(entity);
        }

        @Override
        public NAO getById(Serializable id) {
            return naoRepository.findOne((Long) id);
        }

        @Override
        public List<NAO> getAll() {
            return naoRepository.findAll();
        }

        @Override
        public void delete(Serializable id) {
            naoRepository.delete((Long) id);
        }
}
