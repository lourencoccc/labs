package org.f1.dao.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.f1.dao.EquipeTemporadaDao;
import org.f1.entity.EquipeTemporada;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class EquipeTemporadaHibernateDaoBean extends HibernateDaoBean<EquipeTemporada> implements EquipeTemporadaDao {

    private static final long serialVersionUID = 1L;

    /**
     * @param entityManager
     */
    @Inject
    public EquipeTemporadaHibernateDaoBean(EntityManager entityManager) {
        super(entityManager);
    }

}
