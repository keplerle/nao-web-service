package com.kepler.service;


import com.kepler.model.Prof;
import com.kepler.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DefaultProfService implements ProfService {


    @Autowired
    private ProfRepository profRepository;

    @Override
    public Prof save(Prof entity) {
        return profRepository.save(entity);
    }

    @Override
    public Prof getBy(String mail) {
        return profRepository.findOne(mail);
    }

    @Override
    public void delete(String mail) {
        profRepository.delete(mail);
    }
}
