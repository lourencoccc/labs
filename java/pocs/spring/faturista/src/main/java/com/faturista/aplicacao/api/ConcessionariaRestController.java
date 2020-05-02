package com.faturista.aplicacao.api;

import com.faturista.aplicacao.FaturistaDomainFacade;
import com.faturista.dominio.model.Concessionaria;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/concessionarias")
public class ConcessionariaRestController implements Serializable {

  @Autowired
  private FaturistaDomainFacade faturistaDomainFacade;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Concessionaria> list() {
    return faturistaDomainFacade.buscarTodasConcessionarias();
  }

}
