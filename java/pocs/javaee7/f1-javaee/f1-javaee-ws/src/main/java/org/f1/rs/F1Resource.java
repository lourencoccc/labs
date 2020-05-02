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

import org.f1.entity.EquipeTemporada;
import org.f1.entity.PilotoTemporada;
import org.f1.entity.Temporada;
import org.f1.exception.F1Exception;

@Path("/f1/temporadas")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface F1Resource extends Serializable {

    @GET
    List<Temporada> listarTemporadas(@QueryParam("f") Integer first, @QueryParam("m") Integer max) throws F1Exception;

    @Path("/{id}")
    @GET
    Temporada buscarTemporadaPorId(@PathParam("id") Long id) throws F1Exception;

    @Path("/ano/{ano}")
    @GET
    Temporada buscarTemporadaPorAno(@PathParam("ano") Integer ano) throws F1Exception;

    @POST
    Temporada salvar(Temporada temporada) throws F1Exception;

    @PUT
    Temporada atualizar(Temporada temporada) throws F1Exception;

    @Path("/{id}")
    @DELETE
    void deletarTemporada(@PathParam("id") Long id) throws F1Exception;

    @GET
    @Path("/equipes")
    List<EquipeTemporada> listarEquipes(@QueryParam("f") Integer first, @QueryParam("m") Integer max)
            throws F1Exception;

    @Path("/equipes/{id}")
    @GET
    EquipeTemporada buscarEquipePorId(@PathParam("id") Long id) throws F1Exception;

    @POST
    @Path("/equipes")
    EquipeTemporada salvar(EquipeTemporada equipe) throws F1Exception;

    @PUT
    @Path("/equipes")
    EquipeTemporada atualizar(EquipeTemporada equipe) throws F1Exception;

    @Path("/equipes/{id}")
    @DELETE
    void deletarEquipe(@PathParam("id") Long id) throws F1Exception;

    @GET
    @Path("/pilotos")
    List<PilotoTemporada> listarPilotos(@QueryParam("f") Integer first, @QueryParam("m") Integer max)
            throws F1Exception;

    @Path("/pilotos/{id}")
    @GET
    PilotoTemporada buscarPilotoPorId(@PathParam("id") Long id) throws F1Exception;

    @POST
    @Path("/pilotos")
    PilotoTemporada salvar(PilotoTemporada piloto) throws F1Exception;

    @PUT
    @Path("/pilotos")
    PilotoTemporada atualizar(PilotoTemporada piloto) throws F1Exception;

    @Path("/pilotos/{id}")
    @DELETE
    void deletarPiloto(@PathParam("id") Long id) throws F1Exception;

}
