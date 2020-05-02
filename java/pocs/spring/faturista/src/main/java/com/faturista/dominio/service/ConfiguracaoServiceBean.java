package com.faturista.dominio.service;

import com.faturista.dominio.bo.ConcessionariaBO;
import com.faturista.dominio.model.Concessionaria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component(value = "configuracaoService")
public class ConfiguracaoServiceBean implements ConfiguracaoService {

  private final ConcessionariaBO configureBO;

  @Autowired
  public ConfiguracaoServiceBean(ConcessionariaBO configureBO) {
    this.configureBO = configureBO;
  }

  @Override
  public List<Concessionaria> buscarTodosConcessionarias() {
    return configureBO.buscarTodos();
  }


  @Transactional
  @Override
  public Concessionaria salvarConcessionaria(Concessionaria concessionaria) {
    return null;
  }

}
