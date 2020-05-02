package org.f1.dao.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.f1.dao.Dao;


public class HibernateDaoBean<E> implements Dao<E> {

    private static final long serialVersionUID = 1L;

    protected EntityManager entityManager;

    public HibernateDaoBean(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#persist(java.lang.Object)
     */
    @Override
    public E persist(final E entity) {
        entityManager.persist(entity);
        return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#update(java.lang.Object)
     */
    @Override
    public E update(final E entity) {
        entityManager.merge(entity);
        return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#findById(java.lang.Class, java.lang.Object)
     */
    @Override
    public E findById(final Class<E> clazz, final Object id) {
        return entityManager.find(clazz, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#findAll(java.lang.Class)
     */
    @Override
    public List<E> findAll(final Class<E> clazz) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteria = builder.createQuery(clazz);
        Root<E> root = criteria.from(clazz);
        criteria.select(root);
        TypedQuery<E> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#find(java.util.Map, java.lang.Class)
     */
    @Override
    public List<E> find(final Map<String, Object> queryParameters, final Class<E> clazz) {
        return find(queryParameters, clazz, null, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#find(java.util.Map, java.lang.Class,
     * java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<E> find(final Map<String, Object> queryParameters, final Class<E> clazz, Integer firstResult,
            Integer maxResults) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<E> root = criteriaQuery.from(clazz);
        Predicate[] predicates = extractPredicates(queryParameters, criteriaBuilder, root);
        criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
        TypedQuery<E> query = entityManager.createQuery(criteriaQuery);
        if (firstResult != null) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#findWithOrPredicate(java.util.Map,
     * java.lang.Class)
     */
    @Override
    public List<E> findWithOrPredicate(final Map<String, Object> queryParameters, final Class<E> clazz) {
        return findWithOrPredicate(queryParameters, clazz, null, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#findWithOrPredicate(java.util.Map,
     * java.lang.Class, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public List<E> findWithOrPredicate(final Map<String, Object> queryParameters, final Class<E> clazz,
            Integer firstResult, Integer maxResults) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<E> root = criteriaQuery.from(clazz);
        Predicate[] predicates = new Predicate[] { criteriaBuilder.or(extractPredicates(queryParameters,
            criteriaBuilder, root)) };
        criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
        TypedQuery<E> query = entityManager.createQuery(criteriaQuery);
        if (firstResult != null) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    protected Predicate[] extractPredicates(final Map<String, Object> queryParameters,
            final CriteriaBuilder criteriaBuilder, final Root<E> root) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (queryParameters == null) {
            return new Predicate[] {};
        }
        for (String prop : queryParameters.keySet()) {
            predicates.add(criteriaBuilder.equal(root.get(prop), queryParameters.get(prop)));
        }
        return predicates.toArray(new Predicate[] {});
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#flushAndClear()
     */
    @Override
    public void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.ibsoft.dao.Dao#removeAll(java.lang.String)
     */
    @Override
    public int removeAll(final String nomeEntidade) {
        Query query = entityManager.createQuery("delete from " + nomeEntidade);
        return query.executeUpdate();
    }

    @Override
    public void remove(final E entity) {
        if (entity == null) {
            return;
        }
        entityManager.remove(entity);
        entityManager.flush();
    }

    @SuppressWarnings("unchecked")
    protected <T> T getSingleResult(Query query, Class<T> clazz) {
        Object result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return (T) result;
    }

}
