package com.kepler.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<P> {
    P save(P entity);
    P getByString(String string);
    List<P> getAllByString(Iterable<String> strings);
    void delete(String string);
}
