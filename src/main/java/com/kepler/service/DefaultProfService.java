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
    public Prof getByString(String string) {
        return profRepository.findOne(string);
    }

    @Override
    public List<Prof> getAllByString(Iterable<String> strings) {
        return profRepository.findAll(strings);
    }

    @Override
    public void delete(String string) {
        profRepository.delete(string);
    }
}
