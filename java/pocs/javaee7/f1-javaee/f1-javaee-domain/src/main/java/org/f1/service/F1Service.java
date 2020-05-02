package org.f1.service;

import java.io.Serializable;
import java.util.List;

import org.f1.entity.EquipeTemporada;
import org.f1.entity.PilotoTemporada;
import org.f1.entity.Temporada;
import org.f1.exception.F1Exception;

/**
 * 
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public interface F1Service extends Serializable {

    /**
     * @param EquipeTemporada
     */
    EquipeTemporada salvar(EquipeTemporada EquipeTemporada) throws F1Exception;

    /**
     * @param EquipeTemporada
     */
    EquipeTemporada atualizar(EquipeTemporada EquipeTemporada) throws F1Exception;

    /**
     * 
     * @param id
     * @throws F1Exception
     */
    void deletarEquipeTemporada(Long id) throws F1Exception;

    /**
     * @param id
     * @return
     */
    EquipeTemporada buscarEquipeTemporada(Long id);

    /**
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<EquipeTemporada> listarEquipeTemporada(Integer firstResult, Integer maxResults);

    /**
     * 
     * @param piloto
     * @return
     * @throws F1Exception
     */
    PilotoTemporada salvar(PilotoTemporada piloto) throws F1Exception;

    /**
     * 
     * @param piloto
     * @return
     * @throws F1Exception
     */
    PilotoTemporada atualizar(PilotoTemporada piloto) throws F1Exception;

    /**
     * 
     * @param id
     * @throws F1Exception
     */
    void deletarPilotoTemporada(Long id) throws F1Exception;

    /**
     * 
     * @param id
     * @return
     */
    PilotoTemporada buscarPilotoTemporada(Long id);

    /**
     * 
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<PilotoTemporada> listarPilotoTemporada(Integer firstResult, Integer maxResults);

    /**
     * 
     * @param temporada
     * @return
     * @throws F1Exception
     */
    Temporada salvar(Temporada temporada) throws F1Exception;

    /**
     * 
     * @param temporada
     * @return
     * @throws F1Exception
     */
    Temporada atualizar(Temporada temporada) throws F1Exception;

    /**
     * 
     * @param id
     * @throws F1Exception
     */
    void deletarTemporada(Long id) throws F1Exception;

    /**
     * 
     * @param id
     * @return
     */
    Temporada buscarTemporada(Long id);

    /**
     * 
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<Temporada> listarTemporada(Integer firstResult, Integer maxResults);

    /**
     * 
     * @param ano
     * @return
     * @throws F1Exception
     */
    Temporada buscarTemporadaPor(Integer ano) throws F1Exception;

}
