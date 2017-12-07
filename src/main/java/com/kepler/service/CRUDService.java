package com.kepler.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<P> {
    P save(P entity);
    P getBy(String string);
    void delete(String string);
}

