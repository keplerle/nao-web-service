package com.kepler.service;


import com.kepler.model.NAO;
import com.kepler.repository.NAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DefaultNAOService implements NAOService {

    @Autowired
    private NAORepository naoRepository;

    @Override
    public NAO save(NAO entity) {
        return naoRepository.save(entity);
    }

    @Override
    public NAO getBy(String ip) {
        return naoRepository.findOne(ip);
    }

    @Override
    public NAO getBy(Serializable id) {
        return null;
    }

    @Override
    public List<NAO> findByMailprof(String mail) {
        return naoRepository.findByMailprof(mail);
    }

    @Override
    public void delete(String ip) {
        naoRepository.delete(ip);
    }

    @Override
    public void delete(Serializable id) {

    }
}
