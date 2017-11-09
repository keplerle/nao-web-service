package com.kepler.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<P> {
    P save(P entity);
    P getById(Serializable id);
    List<P> getAll();
    void delete(Serializable id);
}
