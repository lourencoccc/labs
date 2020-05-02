package com.faturista.dominio.service;


import com.faturista.dominio.bo.ClienteBO;
import com.faturista.dominio.bo.FaturaBO;
import com.faturista.dominio.model.Cliente;
import com.faturista.dominio.model.Fatura;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "clienteService")
public class ClienteServiceBean implements ClienteService {

  private final ClienteBO clienteBO;
  private final FaturaBO faturaBO;


  @Autowired
  public ClienteServiceBean(ClienteBO clienteBO, FaturaBO faturaBO) {
    this.clienteBO = clienteBO;
    this.faturaBO = faturaBO;
  }

  @Override
  public List<Cliente> buscarTodosClientes() {
    return clienteBO.buscarTodos();
  }

  @Override
  public List<Fatura> buscarTodasFaturas() {
    return null;
  }

  @Transactional
  @Override
  public Cliente salvarCliente(Cliente cliente) {
    return clienteBO.salvar(cliente);
  }

  @Transactional
  @Override
  public Fatura salvarFatura(Fatura fatura) {
    return faturaBO.salvar(fatura);
  }
}
