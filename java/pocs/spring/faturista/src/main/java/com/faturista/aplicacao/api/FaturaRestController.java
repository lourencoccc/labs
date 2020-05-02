package com.faturista.aplicacao.api;

import com.faturista.aplicacao.FaturistaDomainFacade;
import com.faturista.dominio.model.Fatura;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/faturas")
public class FaturaRestController {

  @Autowired
  private FaturistaDomainFacade faturistaDomainFacade;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Fatura> listar() {
    return null;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public Fatura salvar(@RequestParam Map<String, String> queryMap) {
//    Fatura invoice = new Fatura()
    return null;
  }

  @RequestMapping(value = "", method = RequestMethod.PUT)
  public Fatura atualizar(@RequestParam Map<String, String> queryMap) {
//    Fatura invoice = new Fatura()
    return null;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public Fatura buscar(@PathVariable Long id) {
    return null;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public List<Fatura> get(@PathVariable Long id) {
    return null;
  }

}
