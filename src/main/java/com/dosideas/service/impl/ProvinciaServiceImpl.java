package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import java.util.List;
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
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Provincia> buscarPorNombreExacto(String nombre) throws Exception {
        if (nombre == null) {
            throw new NombreInvalidoException("El parametro es null");
        }
        if (nombre.length() < 3) {
            throw new NombreInvalidoException("El parametro tiene menos de tres caracteres");
        }
        return repository.findByNombre(nombre);
    }

}
