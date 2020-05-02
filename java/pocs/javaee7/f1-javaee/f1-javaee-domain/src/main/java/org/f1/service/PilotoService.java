package org.f1.service;

import java.io.Serializable;
import java.util.List;

import org.f1.entity.Piloto;
import org.f1.exception.F1Exception;

public interface PilotoService extends Serializable {

    /**
     * @param Piloto
     */
    Piloto salvarPiloto(Piloto piloto) throws F1Exception;

    /**
     * @param Piloto
     */
    Piloto atualizarPiloto(Piloto piloto) throws F1Exception;

    /**
     * @param id
     * @return
     */
    Piloto buscarPiloto(Long id);

    /**
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<Piloto> listarPilotos(Integer firstResult, Integer maxResults);

    /**
     * 
     * @param id
     * @throws F1Exception
     */
    void deletarPiloto(Long id) throws F1Exception;
}
