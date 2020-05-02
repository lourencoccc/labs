package org.f1.dao.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.f1.dao.PilotoDao;
import org.f1.entity.Piloto;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class PilotoHibernateDaoBean extends HibernateDaoBean<Piloto> implements PilotoDao {

    private static final long serialVersionUID = 1L;

    /**
     * @param entityManager
     */
    @Inject
    public PilotoHibernateDaoBean(EntityManager entityManager) {
        super(entityManager);
    }

}
