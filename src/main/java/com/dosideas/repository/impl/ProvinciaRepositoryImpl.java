package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProvinciaRepositoryImpl implements ProvinciaRepository {

    @Override
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
