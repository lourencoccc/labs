package produces

import groovy.transform.TypeChecked

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Produces
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.PersistenceContext
import javax.persistence.PersistenceUnit

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
class DaoProduces {
    //@PersistenceUnit(unitName = "example")
    //@ApplicationScoped
    //private EntityManagerFactory entityManagerFactory;

    @PersistenceContext(unitName = "example")
    private EntityManager entityManager;

    @Produces
    public EntityManager getEntityManager() {
        //return entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
