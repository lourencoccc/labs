package org.f1.rs;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.f1.entity.Equipe;
import org.f1.exception.F1Exception;

@Path("/equipes")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface EquipeResource extends Serializable {

    @GET
    List<Equipe> listar(@QueryParam("f") Integer first, @QueryParam("m") Integer max) throws F1Exception;

    @Path("/{id}")
    @GET
    Equipe buscarEquipePor(@PathParam("id") Long id) throws F1Exception;

    @POST
    Equipe salvar(Equipe equipe) throws F1Exception;

    @PUT
    Equipe atualizar(Equipe equipe) throws F1Exception;

    @Path("/{id}")
    @DELETE
    void deletar(@PathParam("id") Long id) throws F1Exception;

}
