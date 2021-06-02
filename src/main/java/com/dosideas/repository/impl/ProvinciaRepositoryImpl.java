package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;

public class ProvinciaRepositoryImpl {

    public Provincia findById(long id) {
        if (id < 0) {
            return null;
        }
        Provincia provincia = new Provincia();
        provincia.setId(id);
        provincia.setNombre("Test");
        return provincia;
    }

}
