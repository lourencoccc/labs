package main

import groovy.transform.TypeChecked
import model.Cliente
import org.jboss.weld.environment.se.events.ContainerInitialized
import service.ClienteService
import service.Service

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.inject.Inject

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
@ApplicationScoped
class ExampleMain {

    @Inject
    private ClienteService clienteService;
    @Inject
    private Service service;
    public void main(@Observes ContainerInitialized init) {
        salvarClientePorId(new Random().nextLong())
        service.printHello();
        println "Hahahahahahahahahahaha"
        println clienteService.listarTodosClientes();
    }

   def salvarClientePorId(Long id){
        def cliente = new Cliente();
        cliente.id =  id;
        cliente.email =  "email@email"
        cliente.nome = "nnnnnn"
        clienteService.salvar(cliente);
    }

}
