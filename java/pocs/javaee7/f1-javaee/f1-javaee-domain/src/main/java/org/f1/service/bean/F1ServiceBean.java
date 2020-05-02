/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package org.f1.service.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.f1.entity.EquipeTemporada;
import org.f1.entity.PilotoTemporada;
import org.f1.entity.Temporada;
import org.f1.exception.F1Exception;
import org.f1.repository.TemporadaRepository;
import org.f1.service.F1Service;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Stateless
public class F1ServiceBean implements F1Service {

    private static final long serialVersionUID = 1L;

    @Inject
    private TemporadaRepository temporadaRepository;

    public F1ServiceBean() {
        super();
    }

    public F1ServiceBean(TemporadaRepository temporadaRepository) {
        super();
        this.temporadaRepository = temporadaRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeTemporadaService#salvarEquipeTemporada
     * (br.com.ibsoft.f1. entity.EquipeTemporada)
     */
    @Override
    public EquipeTemporada salvar(EquipeTemporada equipe) throws F1Exception {
        validar(equipe);
        return temporadaRepository.persist(equipe);
    }

    private void validar(EquipeTemporada equipe) throws F1Exception {
        if (equipe == null) {
            throw new F1Exception("error.equipe_temporada.nulo");
        }
        if (equipe.getEquipe() == null) {
            throw new F1Exception("error.equipe_temporada.equipe.nulo");
        }
        if (equipe.getTemporada() == null) {
            throw new F1Exception("error.equipe_temporada.temporada.nulo");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeTemporadaService#atualizarEquipeTemporada
     * (br.com.ibsoft. f1.entity.EquipeTemporada)
     */
    @Override
    public EquipeTemporada atualizar(EquipeTemporada equipe) throws F1Exception {
        validar(equipe);
        if (equipe.getId() == null) {
            return null;
        }
        return temporadaRepository.update(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.EquipeTemporadaService#buscarEquipeTemporada
     * (java.lang.Long)
     */
    @Override
    public EquipeTemporada buscarEquipeTemporada(Long id) {
        return temporadaRepository.findEquipeById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#listarEquipeTemporada(java.lang.Integer
     * , java.lang.Integer)
     */
    @Override
    public List<EquipeTemporada> listarEquipeTemporada(Integer firstResult, Integer maxResults) {
        validarAjustarParamsPaginacao(firstResult, maxResults);
        return temporadaRepository.findEquipeTemporada(null, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#salvarPilotoTemporada(br.com.ibsoft
     * .f1.entity.PilotoTemporada)
     */
    @Override
    public PilotoTemporada salvar(PilotoTemporada piloto) throws F1Exception {
        validar(piloto);
        return temporadaRepository.persist(piloto);
    }

    private void validar(PilotoTemporada piloto) throws F1Exception {
        if (piloto == null) {
            throw new F1Exception("error.piloto_temporada.nulo");
        }
        if (piloto.getPiloto() == null) {
            throw new F1Exception("error.piloto_temporada.piloto.nulo");
        }
        if (piloto.getEquipe() == null) {
            throw new F1Exception("error.piloto_temporada.equipe.nulo");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#atualizarPilotoTemporada(br.com.ibsoft
     * .f1.entity.PilotoTemporada)
     */
    @Override
    public PilotoTemporada atualizar(PilotoTemporada piloto) throws F1Exception {
        validar(piloto);
        if (piloto.getId() == null) {
            return null;
        }
        return temporadaRepository.update(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#buscarPilotoTemporada(java.lang.Long)
     */
    @Override
    public PilotoTemporada buscarPilotoTemporada(Long id) {
        return temporadaRepository.findPilotoById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#listarPilotoTemporada(java.lang.Integer
     * , java.lang.Integer)
     */
    @Override
    public List<PilotoTemporada> listarPilotoTemporada(Integer firstResult, Integer maxResults) {
        validarAjustarParamsPaginacao(firstResult, maxResults);
        return temporadaRepository.findPilotoTemporada(null, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#salvarTemporada(br.com.ibsoft.f1.entity
     * .Temporada)
     */
    @Override
    public Temporada salvar(Temporada temporada) throws F1Exception {
        validar(temporada);
        return temporadaRepository.persist(temporada);
    }

    private void validar(Temporada temporada) throws F1Exception {
        if (temporada == null) {
            throw new F1Exception("error.temporada.nulo");
        }
        if (temporada.getAno() == null) {
            throw new F1Exception("error.temporada.ano.nulo");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#atualizarTemporada(br.com.ibsoft.f1
     * .entity.Temporada)
     */
    @Override
    public Temporada atualizar(Temporada temporada) throws F1Exception {
        validar(temporada);
        if (temporada.getId() == null) {
            return null;
        }
        return temporadaRepository.update(temporada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.service.F1Service#buscarTemporada(java.lang.Long)
     */
    @Override
    public Temporada buscarTemporada(Long id) {
        return temporadaRepository.findTemporadaById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#listarTemporada(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<Temporada> listarTemporada(Integer firstResult, Integer maxResults) {
        validarAjustarParamsPaginacao(firstResult, maxResults);
        return temporadaRepository.findTemporada(null, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#buscarTemporadaPorAno(java.lang.Integer
     * )
     */
    @Override
    public Temporada buscarTemporadaPor(Integer ano) throws F1Exception {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("ano", ano);
        List<Temporada> ts = temporadaRepository.findTemporada(params, 0, 2);

        if (ts.size() > 1) {
            throw new F1Exception("erro.existe.mais.uma.temporada.com.mesmo.ano");
        }

        return ts != null && ts.size() > 0 ? ts.get(0) : null;
    }

    private void validarAjustarParamsPaginacao(Integer firstResult, Integer maxResults) {
        if (maxResults == null || maxResults < 0 || maxResults > 50) {
            maxResults = 50;
        }
        if (firstResult == null || firstResult < 0) {
            firstResult = 0;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#deletarEquipeTemporada(java.lang.Long)
     */
    @Override
    public void deletarEquipeTemporada(Long id) throws F1Exception {
        EquipeTemporada equipe = buscarEquipeTemporada(id);
        if (equipe != null) {
            temporadaRepository.remove(equipe);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.service.F1Service#deletarPilotoTemporada(java.lang.Long)
     */
    @Override
    public void deletarPilotoTemporada(Long id) throws F1Exception {
        PilotoTemporada piloto = buscarPilotoTemporada(id);
        if (piloto != null) {
            temporadaRepository.remove(piloto);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.f1.service.F1Service#deletarTemporada(java.lang.Long)
     */
    @Override
    public void deletarTemporada(Long id) throws F1Exception {
        Temporada temporada = buscarTemporada(id);
        if (temporada != null) {
            temporadaRepository.remove(temporada);
        }
    }

}
