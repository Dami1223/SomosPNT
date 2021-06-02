package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {
    
    @Autowired
    private final ProvinciaRepository repository;

    public ProvinciaServiceImpl(ProvinciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Provincia buscarPorId(long id) {
        return repository.findById(id);
    }

}
