package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceTest {

    @Autowired
    ProvinciaService provinciaService;

    @Test
    public void buscarPorId_conIdExistente_retornaProvinciaDeEseId() {
        long id = 1;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia.getId()).isEqualTo(id);
    }

    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        long id = -1;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia).isNull();
    }

}
