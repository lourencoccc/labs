package org.f1.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.f1.entity.Piloto;
import org.f1.exception.F1Exception;
import org.f1.service.PilotoService;

@Named
@RequestScoped
public class PilotoController {


	private Piloto piloto = new Piloto();
	private List<Piloto> pilotos; 
	
	@Inject
	private PilotoService pilotoService;

	public void pesquisar() throws F1Exception {
		pilotos = pilotoService.listarPilotos(0, 10);
	}

	public Piloto buscarPilotoPor() throws F1Exception {
		return pilotoService.buscarPiloto(piloto.getId());
	}

	public String salvar() throws F1Exception {
		pilotoService.salvarPiloto(piloto);
		return "pages/piloto-list";
	}

	public void deletar() throws F1Exception {
		pilotoService.deletarPiloto(piloto.getId());
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public List<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	
	
	

}
