package com.faturista.aplicacao;

import com.faturista.dominio.model.Cliente;
import com.faturista.dominio.model.Fatura;
import com.faturista.dominio.model.Concessionaria;
import java.io.Serializable;
import java.util.List;

public interface FaturistaDomainFacade extends Serializable {

  List<Concessionaria> buscarTodasConcessionarias();

  Concessionaria salvarConcessionaria(Concessionaria concessionaria);

  List<Cliente> buscarTodosClientes();

  List<Fatura> buscarTodasFaturas();

  Cliente salarCliente(Cliente cliente);

  Fatura salvarFatura(Fatura fatura);

}
