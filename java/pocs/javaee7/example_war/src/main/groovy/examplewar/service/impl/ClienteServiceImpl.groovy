package examplewar.service.impl

import examplewar.model.Cliente
import examplewar.service.ClienteService
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

import javax.ejb.Stateless
import javax.inject.Inject
import javax.persistence.EntityManager

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
@Stateless
class ClienteServiceImpl implements ClienteService{

//    @Inject
    private EntityManager entityManager

    ClienteServiceImpl() {
    }

    @Inject
    ClienteServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager
    }

    @Override
    List<Cliente> listarTodosClientes() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    Cliente salvar(Cliente cliente) {
        entityManager.persist(cliente)
        return cliente
    }

    @Override
    Cliente atualizar(Cliente cliente) {
        entityManager.merge(cliente)
        return cliente
    }

    @Override
    Cliente buscarClientePorId(Long id) {
        return entityManager.find(Cliente.class, id)
    }
}
