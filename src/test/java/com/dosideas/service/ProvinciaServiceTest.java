package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import java.util.List;
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

    @Test
    public void buscarPorNombreExacto_conNombreMenosTresCaracteres_lanzaException() {
        String nombre = "as";
        try {
            provinciaService.buscarPorNombreExacto(nombre);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("El parametro tiene menos de tres caracteres");
        }
    }

    @Test
    public void buscarPorNombreExacto_conNombreNull_lanzaException() {
        String nombre = null;
        try {
            provinciaService.buscarPorNombreExacto(nombre);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("El parametro es null");
        }
    }

    @Test
    public void buscarPorNombreExacto_conNombreExistente_retornaProvinciasConEseNombre() {
        String nombre = "Buenos Aires";
        try {
            List<Provincia> provincias = provinciaService.buscarPorNombreExacto(nombre);
            assertThat(provincias).isNotEmpty();
            for (Provincia provincia : provincias) {
                assertThat(provincia.getNombre()).isEqualTo(nombre);
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }

    }

    @Test
    public void buscarPorNombreGeneral_conNombreNull_lanzaException() {
        String nombre = null;
        try {
            List<Provincia> provincias = provinciaService.buscarPorNombreGeneral(nombre);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("El parametro es null");
        }
    }

    @Test
    public void buscarPorNombreGeneral_conNombreInexistente_retornaNull() {
        String subString = "8";
        try {
            List<Provincia> provincias = provinciaService.buscarPorNombreGeneral(subString);
            assertThat(provincias).isNull();
        } catch (Exception e) {
            System.err.println(e.getCause());
        }

    }

    @Test
    public void buscarPorNombreGeneral_conNombreExistente_retornaProvinciasQueContienenLaStringEnNombre() {
        String subString = "al";
        try {
            List<Provincia> provincias = provinciaService.buscarPorNombreGeneral(subString);
            assertThat(provincias).isNotNull();
            assertThat(provincias).isNotEmpty();
            for (Provincia provincia : provincias) {
                assertThat(provincia.getNombre()).contains(subString);
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }

    }

}
