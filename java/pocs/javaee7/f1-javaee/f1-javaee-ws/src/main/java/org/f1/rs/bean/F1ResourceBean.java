/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package org.f1.rs.bean;

import java.util.List;

import javax.inject.Inject;

import org.f1.entity.EquipeTemporada;
import org.f1.entity.PilotoTemporada;
import org.f1.entity.Temporada;
import org.f1.exception.F1Exception;
import org.f1.rs.F1Resource;
import org.f1.service.F1Service;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class F1ResourceBean implements F1Resource {

    private static final long serialVersionUID = 1L;

    @Inject
    private F1Service f1Service;

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#listarTemporadas(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Temporada> listarTemporadas(Integer first, Integer max) throws F1Exception {
        return f1Service.listarTemporada(first, max);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#buscarTemporadaPorId(java.lang.Long)
     */
    @Override
    public Temporada buscarTemporadaPorId(Long id) throws F1Exception {
        return f1Service.buscarTemporada(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.F1Resource#buscarTemporadaPorAno(java.lang.Integer)
     */
    @Override
    public Temporada buscarTemporadaPorAno(Integer ano) throws F1Exception {
        return f1Service.buscarTemporadaPor(ano);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.F1Resource#salvar(br.com.ibsoft.f1.entity.Temporada)
     */
    @Override
    public Temporada salvar(Temporada temporada) throws F1Exception {
        return f1Service.salvar(temporada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.F1Resource#atualizar(br.com.ibsoft.f1.entity.Temporada
     * )
     */
    @Override
    public Temporada atualizar(Temporada temporada) throws F1Exception {
        return f1Service.atualizar(temporada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#deletarTemporada(java.lang.Long)
     */
    @Override
    public void deletarTemporada(Long id) throws F1Exception {
        f1Service.deletarTemporada(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#listarEquipes(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<EquipeTemporada> listarEquipes(Integer first, Integer max) throws F1Exception {
        return f1Service.listarEquipeTemporada(first, max);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#buscarEquipePorId(java.lang.Long)
     */
    @Override
    public EquipeTemporada buscarEquipePorId(Long id) throws F1Exception {
        return f1Service.buscarEquipeTemporada(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.F1Resource#salvar(br.com.ibsoft.f1.entity.EquipeTemporada
     * )
     */
    @Override
    public EquipeTemporada salvar(EquipeTemporada equipe) throws F1Exception {
        return f1Service.salvar(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#atualizar(br.com.ibsoft.f1.entity.
     * EquipeTemporada)
     */
    @Override
    public EquipeTemporada atualizar(EquipeTemporada equipe) throws F1Exception {
        return f1Service.atualizar(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#deletarEquipe(java.lang.Long)
     */
    @Override
    public void deletarEquipe(Long id) throws F1Exception {
        f1Service.deletarEquipeTemporada(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#listarPilotos(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<PilotoTemporada> listarPilotos(Integer first, Integer max) throws F1Exception {
        return f1Service.listarPilotoTemporada(first, max);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#buscarPilotoPorId(java.lang.Long)
     */
    @Override
    public PilotoTemporada buscarPilotoPorId(Long id) throws F1Exception {
        return f1Service.buscarPilotoTemporada(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.rs.F1Resource#salvar(br.com.ibsoft.f1.entity.PilotoTemporada
     * )
     */
    @Override
    public PilotoTemporada salvar(PilotoTemporada piloto) throws F1Exception {
        return f1Service.salvar(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#atualizar(br.com.ibsoft.f1.entity.
     * PilotoTemporada)
     */
    @Override
    public PilotoTemporada atualizar(PilotoTemporada piloto) throws F1Exception {
        return f1Service.atualizar(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.rs.F1Resource#deletarPiloto(java.lang.Long)
     */
    @Override
    public void deletarPiloto(Long id) throws F1Exception {
        f1Service.deletarPilotoTemporada(id);
    }

}
