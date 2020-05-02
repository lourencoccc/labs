package org.f1.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.f1.entity.Temporada;

@Named
@RequestScoped
public class TemporadaController {

    @Named
    @Produces
    @RequestScoped
    private Temporada newTemporada = new Temporada();
    
	public TemporadaController() {
		// TODO Auto-generated constructor stub
	}

}
