package service.impl

import model.Cliente
import service.ClienteService
import groovy.transform.TypeChecked

import javax.ejb.Stateless
import javax.inject.Inject
import javax.persistence.EntityManager

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
class ClienteServiceImpl implements ClienteService{

    @Inject
    private EntityManager entityManager;

    @Override
    List<Cliente> listarTodosClientes() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    Cliente salvar(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Override
    Cliente atualizar(Cliente cliente) {
        entityManager.merge(cliente);
        return cliente;
    }

    @Override
    Cliente buscarClientePorId(Long id) {
        return entityManager.find(Cliente.class, id);
    }
}
