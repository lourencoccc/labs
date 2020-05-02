package org.f1.repository.bean;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.f1.dao.EquipeTemporadaDao;
import org.f1.dao.PilotoTemporadaDao;
import org.f1.dao.TemporadaDao;
import org.f1.entity.EquipeTemporada;
import org.f1.entity.PilotoTemporada;
import org.f1.entity.Temporada;
import org.f1.repository.TemporadaRepository;

public class TeporadaRepositoryBean implements TemporadaRepository {

    private static final long serialVersionUID = 1L;

    @Inject
    private PilotoTemporadaDao pilotoTemporadaDao;
    @Inject
    private EquipeTemporadaDao equipeTemporadaDao;
    @Inject
    private TemporadaDao temporadaDao;

    public TeporadaRepositoryBean() {
        super();
    }

    public TeporadaRepositoryBean(PilotoTemporadaDao pilotoTemporadaDao, EquipeTemporadaDao equipeTemporadaDao,
            TemporadaDao temporadaDao) {
        super();
        this.pilotoTemporadaDao = pilotoTemporadaDao;
        this.equipeTemporadaDao = equipeTemporadaDao;
        this.temporadaDao = temporadaDao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#persist(br.com.ibsoft
     * .f1.entity.PilotoTemporada)
     */
    @Override
    public PilotoTemporada persist(PilotoTemporada piloto) {
        return pilotoTemporadaDao.persist(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#update(br.com.ibsoft.
     * f1.entity.PilotoTemporada)
     */
    @Override
    public PilotoTemporada update(PilotoTemporada piloto) {
        if (piloto == null || piloto.getId() == null) {
            return null;
        }
        return pilotoTemporadaDao.update(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#findPilotoById(java.lang
     * .Long)
     */
    @Override
    public PilotoTemporada findPilotoById(Long id) {
        return pilotoTemporadaDao.findById(PilotoTemporada.class, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#findPilotoTemporada(java
     * .util.Map, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<PilotoTemporada> findPilotoTemporada(Map<String, Object> queryParameters, Integer firstResult,
            Integer maxResults) {
        return pilotoTemporadaDao.find(queryParameters, PilotoTemporada.class, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#persist(br.com.ibsoft
     * .f1.entity.EquipeTemporada)
     */
    @Override
    public EquipeTemporada persist(EquipeTemporada equipe) {
        return equipeTemporadaDao.persist(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#update(br.com.ibsoft.
     * f1.entity.EquipeTemporada)
     */
    @Override
    public EquipeTemporada update(EquipeTemporada equipe) {
        if (equipe == null || equipe.getId() == null) {
            return null;
        }
        return equipeTemporadaDao.update(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#findEquipeById(java.lang
     * .Long)
     */
    @Override
    public EquipeTemporada findEquipeById(Long id) {
        return equipeTemporadaDao.findById(EquipeTemporada.class, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#findEquipeTemporada(java
     * .util.Map, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<EquipeTemporada> findEquipeTemporada(Map<String, Object> queryParameters, Integer firstResult,
            Integer maxResults) {
        return equipeTemporadaDao.find(queryParameters, EquipeTemporada.class, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#persist(br.com.ibsoft
     * .f1.entity.Temporada)
     */
    @Override
    public Temporada persist(Temporada temporada) {
        return temporadaDao.persist(temporada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#update(br.com.ibsoft.
     * f1.entity.Temporada)
     */
    @Override
    public Temporada update(Temporada temporada) {
        if (temporada == null || temporada.getId() == null) {
            return null;
        }
        return temporadaDao.update(temporada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#findTemporadaById(java
     * .lang.Long)
     */
    @Override
    public Temporada findTemporadaById(Long id) {
        return temporadaDao.findById(Temporada.class, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#findTemporada(java.util
     * .Map, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<Temporada> findTemporada(Map<String, Object> queryParameters, Integer firstResult, Integer maxResults) {
        return temporadaDao.find(queryParameters, Temporada.class, firstResult, maxResults);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#remove(br.com.ibsoft.
     * f1.entity.PilotoTemporada)
     */
    @Override
    public void remove(PilotoTemporada piloto) {
        pilotoTemporadaDao.remove(piloto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#remove(br.com.ibsoft.
     * f1.entity.EquipeTemporada)
     */
    @Override
    public void remove(EquipeTemporada equipe) {
        equipeTemporadaDao.remove(equipe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.ibsoft.f1.repository.TemporadaRepository#remove(br.com.ibsoft.
     * f1.entity.Temporada)
     */
    @Override
    public void remove(Temporada temporada) {
        temporadaDao.remove(temporada);
    }

}
