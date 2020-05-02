package examplewar.rest.impl

import examplewar.model.Cliente
import examplewar.rest.ClienteResource
import examplewar.service.ClienteService
import groovy.transform.TypeChecked

import javax.inject.Inject

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
class ClienteResourceImpl implements ClienteResource{

    @Inject
    private ClienteService clienteService;

    @Override
    List<Cliente> listarTodosClientes() {
        return clienteService.listarTodosClientes()
    }

    @Override
    Cliente buscarClientePorId(Long id) {
        return clienteService.buscarClientePorId(id)
    }

    @Override
    void salvarClientePorId(Long id){
        def cliente = new Cliente();
        cliente.id =  id;
        cliente.email =  "email@email"
        cliente.nome = "nnnnnn"
        clienteService.salvar(cliente);
    }

}
