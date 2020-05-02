package examplewar.produces

import groovy.transform.TypeChecked

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Produces
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.PersistenceUnit

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
class DaoProduces {
    @PersistenceUnit(unitName = "example_war")
    @ApplicationScoped
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
