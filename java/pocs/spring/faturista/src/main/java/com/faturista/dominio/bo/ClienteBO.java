package com.faturista.dominio.bo;

import com.faturista.dominio.calculo.CalculoBandeiraFactory;
import com.faturista.dominio.calculo.CalculoBandeiraStrategy;
import com.faturista.dominio.model.Cliente;
import com.faturista.dominio.model.Fatura;
import com.faturista.integracao.ClienteDao;
import com.faturista.integracao.FaturaDao;
import com.faturista.integracao.po.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component(value = "clienteBO")
public class ClienteBO {

  private final ClienteDao clienteDao;
  private final CalculoBandeiraFactory calculoBandeiraFactory;

  @Autowired
  public ClienteBO(ClienteDao clienteDao,
      CalculoBandeiraFactory calculoBandeiraFactory) {
    this.clienteDao = clienteDao;
    this.calculoBandeiraFactory = calculoBandeiraFactory;
  }

  public List<Cliente> buscarTodos() {
    List<Cliente> clientes = new ArrayList<>();
    for (ClienteEntity entity : clienteDao.findAll()) {
      clientes.add(new Cliente(entity.getId(),
          entity.getDocumento(), entity.getNome(),
          entity.getEmail()));
    }
    return clientes;
  }

  public Cliente salvar(Cliente cliente) {
    return null;
  }


}
