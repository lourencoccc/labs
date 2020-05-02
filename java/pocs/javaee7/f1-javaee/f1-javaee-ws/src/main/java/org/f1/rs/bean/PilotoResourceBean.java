/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package org.f1.rs.bean;

import java.util.List;

import javax.inject.Inject;

import org.f1.entity.Equipe;
import org.f1.entity.Piloto;
import org.f1.exception.F1Exception;
import org.f1.rs.PilotoResource;
import org.f1.service.PilotoService;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class PilotoResourceBean implements PilotoResource {

    private static final long serialVersionUID = 1L;

    @Inject
    private PilotoService pilotoService;

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.PilotoResource#listarPilotos(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Piloto> listar(Integer first, Integer max) throws F1Exception {
        return pilotoService.listarPilotos(first, max);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.PilotoResource#buscarPilotoPorId(java.lang.Long)
     */
    @Override
    public Piloto buscarPilotoPor(Long id) throws F1Exception {
        return pilotoService.buscarPiloto(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.PilotoResource#salvarPiloto(br.com.ibsoft.f1.entity
     * .Piloto)
     */
    @Override
    public Piloto salvar(Piloto piloto) throws F1Exception {
        return pilotoService.salvarPiloto(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.PilotoResource#atualizarPiloto(br.com.ibsoft.f1.entity
     * .Piloto)
     */
    @Override
    public Equipe atualizar(Piloto piloto) throws F1Exception {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.PilotoResource#deletarPiloto(java.lang.Long)
     */
    @Override
    public void deletar(Long id) throws F1Exception {
        pilotoService.deletarPiloto(id);
    }

}
