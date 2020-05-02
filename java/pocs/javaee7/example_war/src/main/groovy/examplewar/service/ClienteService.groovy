package examplewar.service

import examplewar.model.Cliente
import groovy.transform.TypeChecked

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
public interface ClienteService extends Serializable{

    List<Cliente> listarTodosClientes();

    Cliente salvar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    Cliente buscarClientePorId(Long id);
}