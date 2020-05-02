package org.f1.dao.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.f1.dao.PilotoTemporadaDao;
import org.f1.entity.PilotoTemporada;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class PilotoTemporadaHibernateDaoBean extends HibernateDaoBean<PilotoTemporada> implements PilotoTemporadaDao {

    private static final long serialVersionUID = 1L;

    /**
     * @param entityManager
     */
    @Inject
    public PilotoTemporadaHibernateDaoBean(EntityManager entityManager) {
        super(entityManager);
    }

}
