package org.f1.dao.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.f1.dao.TemporadaDao;
import org.f1.entity.Temporada;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class TemporadaHibernateDaoBean extends HibernateDaoBean<Temporada> implements TemporadaDao {

    private static final long serialVersionUID = 1L;

    /**
     * @param entityManager
     */
    @Inject
    public TemporadaHibernateDaoBean(EntityManager entityManager) {
        super(entityManager);
    }

}
