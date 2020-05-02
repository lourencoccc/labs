package examplewar.service

import examplewar.model.Cliente
import examplewar.service.impl.ClienteServiceImpl
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.Query

/**
 * Created by joao on 19/05/14.
 */
class ClienteServiceSpec extends Specification{

    def "Deve chamar persist do Entity Manager"(){
        given:
        def em = Mock(EntityManager)
        def service =  new ClienteServiceImpl(em)
        def cliente = new Cliente(nome: 'joao')

        when:
        service.salvar(cliente)

        then:
        1 * em.persist(cliente)
    }

    def "Deve chamar merge do Entity Manager"(){
        given:
        def em = Mock(EntityManager)
        def service =  new ClienteServiceImpl(em)
        def cliente = new Cliente(id: 1, nome: 'joao')

        when:
        service.atualizar(cliente)

        then:
        1 * em.merge(cliente)
    }

    def "Deve chamar buscar cliente por ID"(){
        given:
        def em = Mock(EntityManager)
        def cliente = new Cliente(id: 1, nome: 'joao')
        em.find(Cliente.class, 1) >> cliente
        def service =  new ClienteServiceImpl(em)

        when:
        def clienteResult = service.buscarClientePorId(1)

        then:
        clienteResult ==  cliente
    }

    def "Deve listar todos os clientes"(){
        given:
        def cliente = new Cliente(id: 1, nome: 'joao')
        def em = Mock(EntityManager)
        def query = Mock(Query)
        em.createQuery(_) >> query
        query.getResultList() >> [cliente]
        def service =  new ClienteServiceImpl(em)

        when:
        def clientesResult = service.listarTodosClientes()

        then:
        clientesResult[0] ==  cliente
    }

}
