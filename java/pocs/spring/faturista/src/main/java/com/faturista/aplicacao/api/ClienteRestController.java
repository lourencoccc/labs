package com.faturista.aplicacao.api;

import com.faturista.aplicacao.FaturistaDomainFacade;
import com.faturista.dominio.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteRestController {

  @Autowired
  private FaturistaDomainFacade faturistaDomainFacade;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Cliente> list() {
    return faturistaDomainFacade.buscarTodosClientes();
  }

}
