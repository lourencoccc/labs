package com.faturista.aplicacao;

import com.faturista.dominio.service.ConfiguracaoService;
import com.faturista.dominio.service.ClienteService;
import com.faturista.dominio.model.Cliente;
import com.faturista.dominio.model.Fatura;
import com.faturista.dominio.model.Concessionaria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "faturistaDomainFacade")
public class FaturistaDomainFacadeBean implements FaturistaDomainFacade {

  private final ConfiguracaoService configureService;
  private final ClienteService clienteService;

  @Autowired
  public FaturistaDomainFacadeBean(ConfiguracaoService configureService,
      ClienteService clienteService) {
    this.configureService = configureService;
    this.clienteService = clienteService;
  }

  @Override
  public List<Concessionaria> buscarTodasConcessionarias() {
    return configureService.buscarTodosConcessionarias();
  }

  @Override
  public Concessionaria salvarConcessionaria(Concessionaria concessionaria) {
    return null;
  }

  @Override
  public List<Cliente> buscarTodosClientes() {
    return clienteService.buscarTodosClientes();
  }

  @Override
  public List<Fatura> buscarTodasFaturas() {
    return null;
  }

  @Override
  public Cliente salarCliente(Cliente cliente) {
    return null;
  }

  @Override
  public Fatura salvarFatura(Fatura fatura) {
    return null;
  }

}
