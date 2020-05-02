package org.f1.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.f1.entity.Piloto;

@Named
@RequestScoped
public class EquipeController {

    @Named
    @Produces
    @RequestScoped
    private Piloto newPiloto =  new Piloto();
    
	public EquipeController() {
		// TODO Auto-generated constructor stub
	}

}
