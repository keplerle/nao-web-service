package com.kepler.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<P> {
    P save(P entity);
    P getBy(String string);
    P getBy(Serializable id);
    void delete(String string);
    void delete(Serializable id);
}

