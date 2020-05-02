package org.f1.service;

import java.io.Serializable;
import java.util.List;

import org.f1.entity.Equipe;
import org.f1.exception.F1Exception;

public interface EquipeService extends Serializable {

    /**
     * @param equipe
     */
    Equipe salvarEquipe(Equipe equipe) throws F1Exception;

    /**
     * @param equipe
     */
    Equipe atualizarEquipe(Equipe equipe) throws F1Exception;

    /**
     * 
     * @param id
     * @throws F1Exception
     */
    void deletarEquipe(Long id) throws F1Exception;

    /**
     * @param id
     * @return
     */
    Equipe buscarEquipe(Long id);

    /**
     * @param firstResult
     * @param maxResults
     * @return
     */
    List<Equipe> listarEquipes(Integer firstResult, Integer maxResults);

}
