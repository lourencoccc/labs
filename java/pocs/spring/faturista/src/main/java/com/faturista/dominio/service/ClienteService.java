package com.faturista.dominio.service;


import com.faturista.dominio.model.Cliente;
import com.faturista.dominio.model.Fatura;

import java.util.List;

public interface ClienteService {

  List<Cliente> buscarTodosClientes();

  List<Fatura> buscarTodasFaturas();

  Cliente salvarCliente(Cliente cliente);

  Fatura salvarFatura(Fatura fatura);


}
