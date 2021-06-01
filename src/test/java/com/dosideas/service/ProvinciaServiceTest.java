package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.repository.impl.ProvinciaRepositoryImpl;
import com.dosideas.service.impl.ProvinciaServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ProvinciaServiceTest {

    @Test
    public void buscarPorId_conIdExistente_retornaProvinciaDeEseId() {
        ProvinciaRepository provinciaRepository = new ProvinciaRepositoryImpl();
        ProvinciaService provinciaService = new ProvinciaServiceImpl(provinciaRepository);
        long id = 1;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia.getId()).isEqualTo(id);
    }

    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        ProvinciaRepository provinciaRepository = new ProvinciaRepositoryImpl();
        ProvinciaService provinciaService = new ProvinciaServiceImpl(provinciaRepository);
        long id = -1;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia).isNull();
    }

}
