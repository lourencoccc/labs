package org.f1.dao.bean;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.f1.dao.EquipeDao;
import org.f1.entity.Equipe;

public class EquipeHibernateDaoBean extends HibernateDaoBean<Equipe> implements EquipeDao {

    private static final long serialVersionUID = 1L;

    @Inject
    public EquipeHibernateDaoBean(EntityManager entityManager) {
        super(entityManager);
    }

}
