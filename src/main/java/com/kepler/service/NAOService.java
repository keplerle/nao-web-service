package com.kepler.service;

import com.kepler.model.NAO;

import java.util.List;

public interface NAOService extends CRUDService<NAO> {
    List<NAO> findByMailprof(String mail);
}
