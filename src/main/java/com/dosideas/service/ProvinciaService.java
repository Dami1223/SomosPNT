package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.List;

public interface ProvinciaService {

    Provincia buscarPorId(long id);

    List<Provincia> buscarPorNombreExacto(String nombre) throws Exception;

}
