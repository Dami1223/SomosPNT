package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;

public class ProvinciaServiceImpl implements ProvinciaService {

    private final ProvinciaRepository repo;

    public ProvinciaServiceImpl(ProvinciaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Provincia buscarPorId(long id) {
        return repo.findById(id);
    }

}
