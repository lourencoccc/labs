package examplewar.rest

import examplewar.model.Cliente
import groovy.transform.TypeChecked

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces

/**
 * Created by lourenco on 13/03/14.
 */
@TypeChecked
@Path("/clientes")
@Consumes("application/json")
@Produces("application/json")
public interface ClienteResource extends Serializable {
    @GET
    List<Cliente> listarTodosClientes();

    @GET
    @Path("/{id}")
    Cliente buscarClientePorId(@PathParam("id") Long id);

    @GET
    @Path("/salvar/{id}")
    void salvarClientePorId(@PathParam("id") Long id);

}
